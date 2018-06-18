package br.com.padaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.padaria.domain.Funcionario;
import br.com.padaria.repositories.FuncionarioRepository;
import br.com.padaria.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}
	public void inserir (Funcionario obj){
		obj.setId(null);
		repo.save(obj);
	}
	public Funcionario update(Funcionario obj) {
		find(obj.getId());

		return repo.save(obj);
	}
	public void delete(Integer id){
	 	Funcionario funcionario = find(id);
	 	funcionario.setAtivo(false);
		update(funcionario);
	}
	public List<Funcionario> findAll(){
		return repo.findAll();
	}
	public Page<Funcionario> findPage(Integer page,Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
