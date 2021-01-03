package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.Informativo;
import com.condoweb.backend.repositories.InformativoRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class InformativoService {
	
	@Autowired
	private InformativoRepository informativoRepository;
	
	public List<Informativo> findAll() {
		return informativoRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Informativo findById(Long id) {
		return informativoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Informativo insert(Informativo informativo) {
		return informativoRepository.save(informativo);
	}

	@Transactional
	public Informativo update(Long id, Informativo informativo) {
		try {
			Informativo entity = informativoRepository.getOne(id);
			updateData(entity, informativo);
			return informativoRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Informativo entity, Informativo informativo) {
		entity.setAssunto(informativo.getAssunto());
		entity.setConteudo(informativo.getConteudo());
		entity.setData(informativo.getData());
	}
	
	@Transactional
	public Informativo update(Informativo informativo) {
		return informativoRepository.save(informativo);
	}
	
	public void delete(Long id) {
		try {
			informativoRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
