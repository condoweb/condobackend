package com.condoweb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condoweb.backend.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
