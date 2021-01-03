package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.Endereco;
import com.condoweb.backend.repositories.EnderecoRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll() {
		return enderecoRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Endereco findById(Long id) {
		return enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Endereco insert(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	@Transactional
	public Endereco update(Long id, Endereco endereco) {
		try {
			Endereco entity = enderecoRepository.getOne(id);
			updateData(entity, endereco);
			return enderecoRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Endereco entity, Endereco endereco) {
		entity.setLogradouro(endereco.getLogradouro());
		entity.setRua(endereco.getRua());
		entity.setNumero(endereco.getNumero());
		entity.setComplemento(endereco.getComplemento());
		entity.setBairro(endereco.getBairro());
		entity.setCidade(endereco.getCidade());
		entity.setEstado(endereco.getEstado());
		entity.setCep(endereco.getCep());
		entity.setObservacao(endereco.getObservacao());
	}
	
	@Transactional
	public Endereco update(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public void delete(Long id) {
		try {
			enderecoRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
