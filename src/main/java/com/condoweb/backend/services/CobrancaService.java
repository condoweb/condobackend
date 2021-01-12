package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.Cobranca;
import com.condoweb.backend.repositories.CobrancaRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class CobrancaService {
	
	@Autowired
	private CobrancaRepository cobrancaRepository;
	
	public List<Cobranca> findAll() {
		return cobrancaRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Cobranca findById(Long id) {
		return cobrancaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Cobranca insert(Cobranca cobranca) {
		return cobrancaRepository.save(cobranca);
	}

	@Transactional
	public Cobranca update(Long id, Cobranca cobranca) {
		try {
			Cobranca entity = cobrancaRepository.getOne(id);
			updateData(entity, cobranca);
			return cobrancaRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Cobranca entity, Cobranca cobranca) {
		entity.setNome(cobranca.getNome());
		entity.setDescricao(cobranca.getDescricao());
		entity.setValor(cobranca.getValor());
		entity.setValorPago(cobranca.getValorPago());
		entity.setDataPagamento(cobranca.getDataPagamento());
		entity.setDataVencimento(cobranca.getDataVencimento());
		entity.setDataReferencia(cobranca.getDataReferencia());
	}
	
	@Transactional
	public Cobranca update(Cobranca cobranca) {
		return cobrancaRepository.save(cobranca);
	}
	
	public void delete(Long id) {
		try {
			cobrancaRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
