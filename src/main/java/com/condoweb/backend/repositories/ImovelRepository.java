package com.condoweb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condoweb.backend.entities.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long>{

}
