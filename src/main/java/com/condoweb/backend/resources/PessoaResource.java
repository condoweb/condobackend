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

import com.condoweb.backend.entities.Pessoa;
import com.condoweb.backend.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public 	ResponseEntity<List<Pessoa>> findAll() {
		return ResponseEntity.ok().body(pessoaService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(pessoaService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(pessoa.getId()).toUri())
				.body(pessoaService.insert(pessoa));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return ResponseEntity.ok().body(pessoaService.update(id, pessoa));
	}
}