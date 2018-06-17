package br.com.padaria.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.padaria.domain.Mesa;
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
	public ResponseEntity<List<Mesa>> findAll() {
		List<Mesa> listMesas = service.findAll();
		return ResponseEntity.ok().body(listMesas);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir (@RequestBody Mesa obj){
		
		service.inserir(obj);
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Mesa obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
