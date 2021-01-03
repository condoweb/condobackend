package com.condoweb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condoweb.backend.entities.ImovelInformativo;

public interface ImovelInformativoRepository extends JpaRepository<ImovelInformativo, Long>{
	
}
