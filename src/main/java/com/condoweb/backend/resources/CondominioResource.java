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

import com.condoweb.backend.entities.Condominio;
import com.condoweb.backend.services.CondominioService;

@RestController
@RequestMapping(value = "/condominios")
public class CondominioResource {
	
	@Autowired
	private CondominioService condominioService;
	
	@GetMapping
	public 	ResponseEntity<List<Condominio>> findAll() {
		return ResponseEntity.ok().body(condominioService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Condominio> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(condominioService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Condominio> insert(@RequestBody Condominio condominio) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(condominio.getId()).toUri())
				.body(condominioService.insert(condominio));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		condominioService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Condominio> update(@PathVariable Long id, @RequestBody Condominio condominio) {
		return ResponseEntity.ok().body(condominioService.update(id, condominio));
	}
}