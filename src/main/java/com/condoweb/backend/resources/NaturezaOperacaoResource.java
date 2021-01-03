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

import com.condoweb.backend.entities.NaturezaOperacao;
import com.condoweb.backend.services.NaturezaOperacaoService;

@RestController
@RequestMapping(value = "/naturezaoperacoes")
public class NaturezaOperacaoResource {
	
	@Autowired
	private NaturezaOperacaoService naturezaOperacaoService;
	
	@GetMapping
	public 	ResponseEntity<List<NaturezaOperacao>> findAll() {
		return ResponseEntity.ok().body(naturezaOperacaoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<NaturezaOperacao> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(naturezaOperacaoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<NaturezaOperacao> insert(@RequestBody NaturezaOperacao naturezaOperacao) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(naturezaOperacao.getId()).toUri())
				.body(naturezaOperacaoService.insert(naturezaOperacao));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		naturezaOperacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<NaturezaOperacao> update(@PathVariable Long id, @RequestBody NaturezaOperacao naturezaOperacao) {
		return ResponseEntity.ok().body(naturezaOperacaoService.update(id, naturezaOperacao));
	}
}