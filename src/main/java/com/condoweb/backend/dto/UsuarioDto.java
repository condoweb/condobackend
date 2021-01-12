package com.condoweb.backend.dto;

import java.io.Serializable;

import com.condoweb.backend.entities.Usuario;

public class UsuarioDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String nomePessoa;
	private String email;
	
	public UsuarioDto() {}

	public UsuarioDto(Long id, String nome, String nomePessoa, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomePessoa = nomePessoa;
		this.email = email;
	}
	
	public UsuarioDto(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.nomePessoa = entity.getPessoa().getNome();
		this.email = entity.getPessoa().getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
