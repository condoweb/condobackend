package com.condoweb.backend.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.condoweb.backend.entities.pk.ImovelInformativoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "imovel_informativo")
public class ImovelInformativo implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ImovelInformativoPK id = new ImovelInformativoPK();
	
	public ImovelInformativo() {}

	public ImovelInformativo(Imovel imovel, Informativo informativo) {
		super();
		id.setImovel(imovel);
		id.setInformativo(informativo);
	}
	
	@JsonIgnore
	public Imovel getImovel() {
		return id.getImovel();
	}

	public void setImovel(Imovel imovel) {
		id.setImovel(imovel);
	}

	public Informativo getInformativo() {
		return id.getInformativo();
	}

	public void setInformativo(Informativo informativo) {
		id.setInformativo(informativo);
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
		ImovelInformativo other = (ImovelInformativo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
