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

import com.condoweb.backend.entities.Cobranca;
import com.condoweb.backend.services.CobrancaService;

@RestController
@RequestMapping(value = "/cobrancas")
public class CobrancaResource {
	
	@Autowired
	private CobrancaService cobrancaService;
	
	@GetMapping
	public 	ResponseEntity<List<Cobranca>> findAll() {
		return ResponseEntity.ok().body(cobrancaService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cobranca> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(cobrancaService.findById(id));
	}
	
	@GetMapping(value = "/cobranca-paga/{idImovel}")
	public ResponseEntity<List<Cobranca>> buscarCobrancaPaga(@PathVariable Long idImovel){
		return ResponseEntity.ok().body(cobrancaService.buscarCobrancaPaga(idImovel));
	}
	
	@GetMapping(value = "/cobranca-nao-paga/{idImovel}")
	public ResponseEntity<List<Cobranca>> buscarCobrancaNaoPaga(@PathVariable Long idImovel){
		return ResponseEntity.ok().body(cobrancaService.buscarCobrancaNaoPaga(idImovel));
	}
	
	@PostMapping
	public ResponseEntity<Cobranca> insert(@RequestBody Cobranca cobranca) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(cobranca.getId()).toUri())
				.body(cobrancaService.insert(cobranca));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		cobrancaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cobranca> update(@PathVariable Long id, @RequestBody Cobranca cobranca) {
		return ResponseEntity.ok().body(cobrancaService.update(id, cobranca));
	}
}