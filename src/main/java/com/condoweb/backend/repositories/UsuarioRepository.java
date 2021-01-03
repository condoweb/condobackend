package com.condoweb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condoweb.backend.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
