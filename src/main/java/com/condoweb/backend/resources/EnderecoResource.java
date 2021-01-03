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

import com.condoweb.backend.entities.Endereco;
import com.condoweb.backend.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public 	ResponseEntity<List<Endereco>> findAll() {
		return ResponseEntity.ok().body(enderecoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(enderecoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(endereco.getId()).toUri())
				.body(enderecoService.insert(endereco));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		enderecoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
		return ResponseEntity.ok().body(enderecoService.update(id, endereco));
	}
}