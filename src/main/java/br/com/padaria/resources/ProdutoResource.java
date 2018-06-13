package br.com.padaria.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.padaria.domain.Produto;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

	@RequestMapping(method=RequestMethod.GET)
	public Produto listar(){
		Produto prod = new Produto(1, "coxinha", 3.5, "feita de frango");
		return prod;
	}
}
