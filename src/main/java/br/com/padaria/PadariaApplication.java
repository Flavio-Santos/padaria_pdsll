package br.com.padaria;

import java.util.ArrayList;
import java.util.Arrays;

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
		Produto prod5 = new Produto(null, "coxinha", 2.5, "coxina de frango",true);
		Produto prod6 = new Produto(null, "coca", 1.5, "feito de cola",true);
		Produto prod7 = new Produto(null, "pepsi", 5.0, "tambem",true);
		Produto prod8 = new Produto(null, "pastel de carne", 4.0, "quente",true);
		Produto prod9 = new Produto(null, "risole", 2.5, "de carne moida",true);
		Produto prod10 = new Produto(null, "pizza", 1.5, "portuguesa",true);
		Produto prod11 = new Produto(null, "cafe", 5.0, "2f",true);
		Produto prod12 = new Produto(null, "leite", 4.0, "Integral",true);
		
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7,prod8,prod9,prod10,prod11,prod12));
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(prod1);
		produtos.add(prod2);
		produtos.add(prod3);
		produtos.add(prod4);
		
		ArrayList<Produto> produtos2 = new ArrayList<Produto>();
		produtos2.add(prod1);
		produtos2.add(prod2);
		produtos2.add(prod5);
		produtos2.add(prod6);
		

		
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
