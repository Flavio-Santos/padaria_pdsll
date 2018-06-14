package br.com.padaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.padaria.domain.Mesa;
import br.com.padaria.repositories.MesaRepository;

@Service
public class MesaService {
	
	@Autowired
	private MesaRepository repo;
	
	public Mesa buscar(Integer id) {
		Optional<Mesa> obj = repo.findById(id);
		return obj.orElse(null);
	}
	public void inserir (Mesa obj){
		obj.setId(null);
		repo.save(obj);
	}
}
