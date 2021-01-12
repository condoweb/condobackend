package com.condoweb.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.condoweb.backend.dto.ImovelDto;
import com.condoweb.backend.entities.Imovel;
import com.condoweb.backend.repositories.ImovelRepository;
import com.condoweb.backend.repositories.UsuarioRepository;
import com.condoweb.backend.services.exceptions.DatabaseException;
import com.condoweb.backend.services.exceptions.ResourceNotFoundException;
import com.google.common.base.Optional;

@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Imovel> findAll() {
		return imovelRepository.findAll().stream().map(e -> e).collect(Collectors.toList());
	}
	
	public Page<Imovel> findAllPaged(Pageable pageable) {
		return imovelRepository.findAll(pageable).map(e -> e);
	}

	public Imovel findById(Long id) {
		return imovelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}	
	
	public ImovelDto buscarImovelUsuario(Long idUsuario) {
		try {
			return new ImovelDto(Optional.of(usuarioRepository.getOne(idUsuario).getImovel()).get());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(idUsuario);
		}
	}

	public Imovel insert(Imovel imovel) {
		return imovelRepository.save(imovel);
	}

	@Transactional
	public Imovel update(Long id, Imovel imovel) {
		try {
			Imovel entity = imovelRepository.getOne(id);
			updateData(entity, imovel);
			return imovelRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Imovel entity, Imovel imovel) {
		entity.setNumero(imovel.getNumero());
		entity.setObservacao(imovel.getObservacao());
	}
	
	@Transactional
	public Imovel update(Imovel imovel) {
		return imovelRepository.save(imovel);
	}
	
	public void delete(Long id) {
		try {
			imovelRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
}
