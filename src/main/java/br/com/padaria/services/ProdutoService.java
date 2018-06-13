package br.com.padaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.padaria.domain.Produto;
import br.com.padaria.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Optional<Produto> buscar(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj;
	}
	public void inserir (Produto obj){
		obj.setId(null);
		repo.save(obj);
	}
}
