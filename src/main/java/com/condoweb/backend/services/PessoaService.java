package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.entities.Pessoa;
import com.condoweb.backend.repositories.PessoaRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Pessoa findById(Long id) {
		return pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Pessoa insert(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Transactional
	public Pessoa update(Long id, Pessoa pessoa) {
		try {
			Pessoa entity = pessoaRepository.getOne(id);
			updateData(entity, pessoa);
			return pessoaRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Pessoa entity, Pessoa pessoa) {
		entity.setNome(pessoa.getNome());;
		entity.setCpf(pessoa.getCpf());;
		entity.setRg(pessoa.getRg());
		entity.setDataNasc(pessoa.getDataNasc());
		entity.setEmail(pessoa.getEmail());
		entity.setCelular(pessoa.getCelular());
		entity.setTelefone(pessoa.getTelefone());;
	}
	
	@Transactional
	public Pessoa update(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void delete(Long id) {
		try {
			pessoaRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
