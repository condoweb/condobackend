package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.NaturezaOperacao;
import com.condoweb.backend.repositories.NaturezaOperacaoRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class NaturezaOperacaoService {
	
	@Autowired
	private NaturezaOperacaoRepository naturezaOperacaoRepository;
	
	public List<NaturezaOperacao> findAll() {
		return naturezaOperacaoRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public NaturezaOperacao findById(Long id) {
		return naturezaOperacaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public NaturezaOperacao insert(NaturezaOperacao naturezaOperacao) {
		return naturezaOperacaoRepository.save(naturezaOperacao);
	}

	@Transactional
	public NaturezaOperacao update(Long id, NaturezaOperacao naturezaOperacao) {
		try {
			NaturezaOperacao entity = naturezaOperacaoRepository.getOne(id);
			updateData(entity, naturezaOperacao);
			return naturezaOperacaoRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(NaturezaOperacao entity, NaturezaOperacao naturezaOperacao) {
		entity.setDescricao(naturezaOperacao.getDescricao());
		entity.setTipo(naturezaOperacao.getTipo());
	}
	
	@Transactional
	public NaturezaOperacao update(NaturezaOperacao naturezaOperacao) {
		return naturezaOperacaoRepository.save(naturezaOperacao);
	}
	
	public void delete(Long id) {
		try {
			naturezaOperacaoRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
