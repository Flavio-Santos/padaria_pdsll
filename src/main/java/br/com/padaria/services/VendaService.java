package br.com.padaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.padaria.domain.Funcionario;
import br.com.padaria.domain.Venda;
import br.com.padaria.repositories.VendaRepository;
import br.com.padaria.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repo;
	
	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}
	public void inserir (Venda obj){
		obj.setId(null);
		repo.save(obj);
	}
	public Venda update(Venda obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public List<Venda> findAll(){
		return repo.findAll();
	}
	public Page<Venda> findPage(Integer page,Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
