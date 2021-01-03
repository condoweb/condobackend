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

import com.condoweb.backend.entities.ContaAReceber;
import com.condoweb.backend.services.ContaAReceberService;

@RestController
@RequestMapping(value = "/contasareceber")
public class ContaAReceberResource {
	
	@Autowired
	private ContaAReceberService contaAReceberService;
	
	@GetMapping
	public 	ResponseEntity<List<ContaAReceber>> findAll() {
		return ResponseEntity.ok().body(contaAReceberService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContaAReceber> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(contaAReceberService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<ContaAReceber> insert(@RequestBody ContaAReceber contaAReceber) {
		return ResponseEntity
				.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(contaAReceber.getId()).toUri())
				.body(contaAReceberService.insert(contaAReceber));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		contaAReceberService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ContaAReceber> update(@PathVariable Long id, @RequestBody ContaAReceber contaAReceber) {
		return ResponseEntity.ok().body(contaAReceberService.update(id, contaAReceber));
	}
}