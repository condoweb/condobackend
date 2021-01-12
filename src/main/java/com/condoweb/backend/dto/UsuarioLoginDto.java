package com.condoweb.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.condoweb.backend.entities.Perfil;
import com.condoweb.backend.entities.Permissao;
import com.condoweb.backend.entities.Usuario;

public class UsuarioLoginDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String nomePessoa;
	private String email;
	private List<Perfil> perfis = new ArrayList<>();
	
	public UsuarioLoginDto() {}
	
	public UsuarioLoginDto(Long id, String nome, String nomePessoa, String email, List<Perfil> perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomePessoa = nomePessoa;
		this.email = email;
		this.perfis = perfis;
	}

	public UsuarioLoginDto(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.nomePessoa = entity.getPessoa().getNome();
		this.email = entity.getPessoa().getEmail();
		for (Permissao p : entity.getPermissoes()) if (p.getStatus() == true) this.perfis.add(p.getPerfil());
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

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
}
