package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.ContaAReceber;
import com.condoweb.backend.repositories.ContaAReceberRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class ContaAReceberService {
	
	@Autowired
	private ContaAReceberRepository contaAReceberRepository;
	
	public List<ContaAReceber> findAll() {
		return contaAReceberRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public ContaAReceber findById(Long id) {
		return contaAReceberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public ContaAReceber insert(ContaAReceber contaAReceber) {
		return contaAReceberRepository.save(contaAReceber);
	}

	@Transactional
	public ContaAReceber update(Long id, ContaAReceber contaAReceber) {
		try {
			ContaAReceber entity = contaAReceberRepository.getOne(id);
			updateData(entity, contaAReceber);
			return contaAReceberRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(ContaAReceber entity, ContaAReceber contaAReceber) {
		entity.setValor(contaAReceber.getValor());
		entity.setValorPago(contaAReceber.getValorPago());
		entity.setDataVencimento(contaAReceber.getDataVencimento());
		entity.setDataPagamento(contaAReceber.getDataPagamento());
		entity.setDataReferencia(contaAReceber.getDataReferencia());;
	}
	
	@Transactional
	public ContaAReceber update(ContaAReceber contaAReceber) {
		return contaAReceberRepository.save(contaAReceber);
	}
	
	public void delete(Long id) {
		try {
			contaAReceberRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
