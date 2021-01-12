package com.condoweb.backend.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "imovel")
public class Imovel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numero;
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "bloco_id")
	private Bloco bloco;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "morador_id")
	private Usuario morador;
	
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Pessoa proprietario;
	
	@OneToMany(mappedBy = "imovel")
	private List<Cobranca> cobrancas;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "condominio_id")
	private Condominio condominio;
	
	@OneToMany(mappedBy = "id.imovel")
	private Set<ImovelInformativo> informativos = new HashSet<>();
	
	public Imovel() {}

	public Imovel(Long id, Integer numero, String observacao, Bloco bloco, Condominio condominio, Usuario morador, Pessoa proprietario) {
		super();
		this.id = id;
		this.numero = numero;
		this.observacao = observacao;
		this.morador = morador;
		this.proprietario = proprietario;
		this.bloco = bloco;
		this.condominio = condominio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Usuario getMorador() {
		return morador;
	}

	public void setMorador(Usuario morador) {
		this.morador = morador;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}

	public List<Cobranca> getCobrancas() {
		return cobrancas;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public Set<ImovelInformativo> getInformativos() {
		return informativos;
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
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
