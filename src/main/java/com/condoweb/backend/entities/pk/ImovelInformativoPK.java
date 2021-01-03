package com.condoweb.backend.entities.pk;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.condoweb.backend.entities.Imovel;
import com.condoweb.backend.entities.Informativo;

public class ImovelInformativoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name = "informativo_id")
	private Informativo informativo;

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Informativo getInformativo() {
		return informativo;
	}

	public void setInformativo(Informativo informativo) {
		this.informativo = informativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imovel == null) ? 0 : imovel.hashCode());
		result = prime * result + ((informativo == null) ? 0 : informativo.hashCode());
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
		ImovelInformativoPK other = (ImovelInformativoPK) obj;
		if (imovel == null) {
			if (other.imovel != null)
				return false;
		} else if (!imovel.equals(other.imovel))
			return false;
		if (informativo == null) {
			if (other.informativo != null)
				return false;
		} else if (!informativo.equals(other.informativo))
			return false;
		return true;
	}
}
