package com.condoweb.backend.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.dto.UsuarioDto;
import com.condoweb.backend.entities.Usuario;
import com.condoweb.backend.repositories.UsuarioRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.NoValuePresentExpection;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public UsuarioDto findByNomeAndSenha(String nome, String senha) {
		try {
			return new UsuarioDto(usuarioRepository.findByNomeAndSenha(nome, senha).get());
		} catch (NoSuchElementException e) {
			throw new NoValuePresentExpection(e.getMessage());
		}
	}

	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Transactional
	public Usuario update(Long id, Usuario usuario) {
		try {
			Usuario entity = usuarioRepository.getOne(id);
			updateData(entity, usuario);
			return usuarioRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Usuario entity, Usuario usuario) {		
		entity.setNome(usuario.getNome());
		entity.setSenha(usuario.getSenha());
	}
	
	@Transactional
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void delete(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
