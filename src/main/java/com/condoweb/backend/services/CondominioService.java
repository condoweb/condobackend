package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.Condominio;
import com.condoweb.backend.repositories.CondominioRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class CondominioService {
	
	@Autowired
	private CondominioRepository condominioRepository;
	
	public List<Condominio> findAll() {
		return condominioRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Condominio findById(Long id) {
		return condominioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Condominio insert(Condominio condominio) {
		return condominioRepository.save(condominio);
	}

	@Transactional
	public Condominio update(Long id, Condominio condominio) {
		try {
			Condominio entity = condominioRepository.getOne(id);
			updateData(entity, condominio);
			return condominioRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Condominio entity, Condominio condominio) {
		entity.setNome(condominio.getNome());
		entity.setQuantApartamentos(condominio.getQuantApartamentos());
		entity.setQuantBlocos(condominio.getQuantBlocos());
	}
	
	@Transactional
	public Condominio update(Condominio condominio) {
		return condominioRepository.save(condominio);
	}
	
	public void delete(Long id) {
		try {
			condominioRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
