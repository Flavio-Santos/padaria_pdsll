package br.com.padaria.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.padaria.domain.Mesa;
import br.com.padaria.domain.Produto;
import br.com.padaria.dto.MesaDTO;
import br.com.padaria.services.MesaService;

@RestController
@RequestMapping(value="/mesas")
public class MesaResource {

	@Autowired
	MesaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Mesa> find(@PathVariable Integer id) {
		Mesa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MesaDTO>> findAll() {
		List<Mesa> listMesas = service.findAll();
		List<MesaDTO> listDto = listMesas.stream().map(obj -> new MesaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir (@RequestBody Mesa obj){
		
		service.inserir(obj);
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	//@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	//public ResponseEntity<Void> update(@RequestBody Mesa obj, @PathVariable Integer id) {
	//	obj.setId(id);
	//	obj = service.update(obj);
	//	return ResponseEntity.noContent().build();
	//}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProdutos(@RequestBody Mesa obj, @PathVariable Integer id) {
		obj.setId(id);
		Double soma = 0.0;
		List<Produto> produtos = new ArrayList<>();
		produtos = obj.getProdutos();
		for (Produto produto : produtos) {
			soma += (produto.getPreco())*produto.getQuantidade();
		}
		obj.setTotal(soma);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
