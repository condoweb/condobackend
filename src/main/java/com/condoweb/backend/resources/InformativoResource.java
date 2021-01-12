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

import com.condoweb.backend.entities.Informativo;
import com.condoweb.backend.services.InformativoService;

@RestController
@RequestMapping(value = "/informativos")
public class InformativoResource {
	
	@Autowired
	private InformativoService informativoService;
	
	@GetMapping
	public 	ResponseEntity<List<Informativo>> findAll() {
		return ResponseEntity.ok().body(informativoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Informativo> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(informativoService.findById(id));
	}
	
	
	@GetMapping(value = "/buscar-informativo-usuario/{idUsuario}")
	public ResponseEntity<List<Informativo>> buscarInformativoUsuario(@PathVariable Long idUsuario){
		return ResponseEntity.ok().body(informativoService.buscarInformativoUsuario(idUsuario));
	}
	
	@PostMapping
	public ResponseEntity<Informativo> insert(@RequestBody Informativo informativo) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(informativo.getId()).toUri())
				.body(informativoService.insert(informativo));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		informativoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Informativo> update(@PathVariable Long id, @RequestBody Informativo informativo) {
		return ResponseEntity.ok().body(informativoService.update(id, informativo));
	}
}