package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.Perfil;
import com.condoweb.backend.repositories.PerfilRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<Perfil> findAll() {
		return perfilRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Perfil findById(Long id) {
		return perfilRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Perfil insert(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	@Transactional
	public Perfil update(Long id, Perfil perfil) {
		try {
			Perfil entity = perfilRepository.getOne(id);
			updateData(entity, perfil);
			return perfilRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Perfil entity, Perfil perfil) {
		entity.setDescricao(perfil.getDescricao());
		entity.setDataCricao(perfil.getDataCricao());
	}
	
	@Transactional
	public Perfil update(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public void delete(Long id) {
		try {
			perfilRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
