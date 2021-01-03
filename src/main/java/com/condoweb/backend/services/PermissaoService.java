package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.Permissao;
import com.condoweb.backend.repositories.PermissaoRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class PermissaoService {
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public List<Permissao> findAll() {
		return permissaoRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Permissao findById(Long id) {
		return permissaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Permissao insert(Permissao permissao) {
		return permissaoRepository.save(permissao);
	}

	@Transactional
	public Permissao update(Long id, Permissao permissao) {
		try {
			Permissao entity = permissaoRepository.getOne(id);
			updateData(entity, permissao);
			return permissaoRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Permissao entity, Permissao permissao) {
		entity.setStatus(permissao.getStatus());
		entity.setData(permissao.getData());
	}
	
	@Transactional
	public Permissao update(Permissao permissao) {
		return permissaoRepository.save(permissao);
	}
	
	public void delete(Long id) {
		try {
			permissaoRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
