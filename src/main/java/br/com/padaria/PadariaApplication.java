package br.com.padaria;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.padaria.domain.Funcionario;
import br.com.padaria.domain.Mesa;
import br.com.padaria.domain.Produto;
import br.com.padaria.repositories.FuncionarioRepository;
import br.com.padaria.repositories.MesaRepository;
import br.com.padaria.repositories.ProdutoRepository;
import br.com.padaria.repositories.VendaRepository;

@SpringBootApplication
public class PadariaApplication implements CommandLineRunner{

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	MesaRepository mesaRepository;
	
	@Autowired
	VendaRepository vendaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PadariaApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Produto prod1 = new Produto(null, "coxinha", 2.5, "coxina de frango",true);
		Produto prod2 = new Produto(null, "kibe", 1.5, "com recheio de queijo",true);
		Produto prod3 = new Produto(null, "torta", 5.0, "torta de frango com catupiry",true);
		Produto prod4 = new Produto(null, "pastel", 4.0, "pastel de calabresa com orégano",true);
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(prod1);
		produtos.add(prod2);
		produtos.add(prod3);
		produtos.add(prod4);
		
		ArrayList<Produto> produtos2 = new ArrayList<Produto>();
		produtos2.add(prod1);
		produtos2.add(prod2);
		
		produtoRepository.saveAll(produtos);
		
		Mesa mesa1 = new Mesa(null, false);
		Mesa mesa2 = new Mesa(null, false);
		Mesa mesa3 = new Mesa(null, false);
		mesa1.setProdutos(produtos);
		mesa2.setProdutos(produtos2);
		
		
		mesaRepository.save(mesa1);
		mesaRepository.save(mesa2);
		mesaRepository.save(mesa3);
		
		Funcionario func1 = new Funcionario(null, "Flavio", true,true);
		
		Funcionario func2 = new Funcionario(null, "Jordi", true,true);
		
		funcionarioRepository.save(func1);
		funcionarioRepository.save(func2);
		
		
		
	}
}
