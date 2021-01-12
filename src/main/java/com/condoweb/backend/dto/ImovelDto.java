package com.condoweb.backend.dto;

import java.io.Serializable;

import com.condoweb.backend.entities.Imovel;

public class ImovelDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer numero;
	private String observacao;
	private String siglaBloco;
	private String descricaoBloco;
	private String proprieterioNome;
	
	public ImovelDto() {}

	public ImovelDto(Long id, Integer numero, String observacao, String siglaBloco, String descricaoBloco,
			String proprieterioNome) {
		super();
		this.id = id;
		this.numero = numero;
		this.observacao = observacao;
		this.siglaBloco = siglaBloco;
		this.descricaoBloco = descricaoBloco;
		this.proprieterioNome = proprieterioNome;
	}
	
	public ImovelDto(Imovel entity) {
		this.id = entity.getId();
		this.numero = entity.getNumero();
		this.observacao = entity.getObservacao();
		this.siglaBloco = entity.getBloco().getSigla();
		this.descricaoBloco = entity.getBloco().getDescricao();
		this.proprieterioNome = entity.getProprietario().getNome();
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

	public String getSiglaBloco() {
		return siglaBloco;
	}

	public void setSiglaBloco(String siglaBloco) {
		this.siglaBloco = siglaBloco;
	}

	public String getDescricaoBloco() {
		return descricaoBloco;
	}

	public void setDescricaoBloco(String descricaoBloco) {
		this.descricaoBloco = descricaoBloco;
	}

	public String getProprieterioNome() {
		return proprieterioNome;
	}

	public void setProprieterioNome(String proprieterioNome) {
		this.proprieterioNome = proprieterioNome;
	}
}
