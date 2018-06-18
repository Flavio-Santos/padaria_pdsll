package br.com.padaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.padaria.domain.Produto;
import br.com.padaria.repositories.ProdutoRepository;
import br.com.padaria.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public void insert(Produto obj) {
		obj.setId(null);
		repo.save(obj);
	}

	public Produto update(Produto obj) {
		find(obj.getId());

		return repo.save(obj);
	}
	public void delete(Integer id){
	 	Produto produto = find(id);
	 	produto.setAtivo(false);
		update(produto);
	}
	public List<Produto> findAll(){
		return repo.findAll();
	}
	public Page<Produto> findPage(Integer page,Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
