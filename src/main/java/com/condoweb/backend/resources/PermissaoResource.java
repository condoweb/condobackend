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

import com.condoweb.backend.entities.Permissao;
import com.condoweb.backend.services.PermissaoService;

@RestController
@RequestMapping(value = "/permissoes")
public class PermissaoResource {
	
	@Autowired
	private PermissaoService permissaoService;
	
	@GetMapping
	public 	ResponseEntity<List<Permissao>> findAll() {
		return ResponseEntity.ok().body(permissaoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Permissao> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(permissaoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Permissao> insert(@RequestBody Permissao permissao) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(permissao.getId()).toUri())
				.body(permissaoService.insert(permissao));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		permissaoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Permissao> update(@PathVariable Long id, @RequestBody Permissao permissao) {
		return ResponseEntity.ok().body(permissaoService.update(id, permissao));
	}
}