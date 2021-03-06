package br.com.padaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.padaria.domain.Mesa;
import br.com.padaria.repositories.MesaRepository;
import br.com.padaria.services.exceptions.ObjectNotFoundException;

@Service
public class MesaService {
	
	@Autowired
	private MesaRepository repo;
	
	public Mesa find(Integer id) {
		Optional<Mesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Mesa.class.getName()));
	}
	public void inserir (Mesa obj){
		obj.setId(null);
		repo.save(obj);
	}
	public Mesa update(Mesa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public List<Mesa> findAll(){
		return repo.findAll();
	}
	public Page<Mesa> findPage(Integer page,Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
