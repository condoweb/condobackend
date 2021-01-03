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

import com.condoweb.backend.entities.Perfil;
import com.condoweb.backend.services.PerfilService;

@RestController
@RequestMapping(value = "/perfis")
public class PerfilResource {
	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
	public 	ResponseEntity<List<Perfil>> findAll() {
		return ResponseEntity.ok().body(perfilService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Perfil> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(perfilService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Perfil> insert(@RequestBody Perfil perfil) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(perfil.getId()).toUri())
				.body(perfilService.insert(perfil));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		perfilService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Perfil> update(@PathVariable Long id, @RequestBody Perfil perfil) {
		return ResponseEntity.ok().body(perfilService.update(id, perfil));
	}
}