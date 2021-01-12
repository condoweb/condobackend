package com.condoweb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


import com.condoweb.backend.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByNomeAndSenha(String nome, String senha);
}
