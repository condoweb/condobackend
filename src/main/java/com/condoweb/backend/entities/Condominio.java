package com.condoweb.backend.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "condominio")
public class Condominio implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer quantApartamentos;
	private Integer quantBlocos;
	
	@OneToMany(mappedBy = "condominio")
	private List<Imovel> imoveis = new ArrayList<>();
	
	@OneToMany(mappedBy = "condominio")
	private List<ContaAReceber> contasAReceber = new ArrayList<>();
	
	public Condominio() {}
	
	public Condominio(Long id, String nome, Integer quantApartamentos, Integer quantBlocos) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantApartamentos = quantApartamentos;
		this.quantBlocos = quantBlocos;
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

	public Integer getQuantApartamentos() {
		return quantApartamentos;
	}

	public void setQuantApartamentos(Integer quantApartamentos) {
		this.quantApartamentos = quantApartamentos;
	}

	public Integer getQuantBlocos() {
		return quantBlocos;
	}

	public void setQuantBlocos(Integer quantBlocos) {
		this.quantBlocos = quantBlocos;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	public List<ContaAReceber> getContasAReceber() {
		return contasAReceber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condominio other = (Condominio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
