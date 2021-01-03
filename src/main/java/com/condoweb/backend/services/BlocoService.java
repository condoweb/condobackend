package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.Bloco;
import com.condoweb.backend.repositories.BlocoRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class BlocoService {
	
	@Autowired
	private BlocoRepository blocoRepository;
	
	public List<Bloco> findAll() {
		return blocoRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Bloco findById(Long id) {
		return blocoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Bloco insert(Bloco bloco) {
		return blocoRepository.save(bloco);
	}

	@Transactional
	public Bloco update(Long id, Bloco bloco) {
		try {
			Bloco entity = blocoRepository.getOne(id);
			updateData(entity, bloco);
			return blocoRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Bloco entity, Bloco bloco) {
		entity.setSigla(bloco.getSigla());
		entity.setDescricao(bloco.getDescricao());
	}
	
	@Transactional
	public Bloco update(Bloco bloco) {
		return blocoRepository.save(bloco);
	}
	
	public void delete(Long id) {
		try {
			blocoRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
