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

import com.condoweb.backend.entities.Bloco;
import com.condoweb.backend.services.BlocoService;

@RestController
@RequestMapping(value = "/blocos")
public class BlocoResource {
	
	@Autowired
	private BlocoService blocoService;
	
	@GetMapping
	public 	ResponseEntity<List<Bloco>> findAll() {
		return ResponseEntity.ok().body(blocoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bloco> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(blocoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Bloco> insert(@RequestBody Bloco bloco) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(bloco.getId()).toUri())
				.body(blocoService.insert(bloco));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		blocoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Bloco> update(@PathVariable Long id, @RequestBody Bloco bloco) {
		return ResponseEntity.ok().body(blocoService.update(id, bloco));
	}
}