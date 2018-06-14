package br.com.padaria;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.padaria.domain.Produto;
import br.com.padaria.repositories.FuncionarioRepository;
import br.com.padaria.repositories.MesaRepository;
import br.com.padaria.repositories.ProdutoRepository;

@SpringBootApplication
public class PadariaApplication implements CommandLineRunner{

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	MesaRepository mesaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PadariaApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Produto prod1 = new Produto(null, "coxinha", 2.5, "coxina de frango");
		Produto prod2 = new Produto(null, "kibe", 1.5, "com recheio de queijo");
		Produto prod3 = new Produto(null, "torta", 5.0, "torta de frango com catupiry");
		Produto prod4 = new Produto(null, "pastel", 4.0, "pastel de calabresa com orégano");
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(prod1);
		produtos.add(prod2);
		produtos.add(prod3);
		produtos.add(prod4);

		produtoRepository.saveAll(produtos);
		
	}
}
