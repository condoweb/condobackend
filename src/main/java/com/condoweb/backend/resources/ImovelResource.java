package com.condoweb.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.condoweb.backend.entities.Imovel;
import com.condoweb.backend.services.ImovelService;

@RestController
@RequestMapping(value = "/imoveis")
public class ImovelResource {
	
	@Autowired
	private ImovelService imovelService;
	
	@GetMapping
	public 	ResponseEntity<List<Imovel>> findAll() {
		return ResponseEntity.ok().body(imovelService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Imovel> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(imovelService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Imovel> insert(@RequestBody Imovel imovel) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(imovel.getId()).toUri())
				.body(imovelService.insert(imovel));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		imovelService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Imovel> update(@PathVariable Long id, @RequestBody Imovel imovel) {
		return ResponseEntity.ok().body(imovelService.update(id, imovel));
	}
}