package com.shuldevelop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CentroDeptoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private CentroCosto centroCosto;
	
	@ManyToOne
	private EstructuraOrg estructuraOrg;

	public CentroCosto getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(CentroCosto centroCosto) {
		this.centroCosto = centroCosto;
	}

	public EstructuraOrg getEstructuraOrg() {
		return estructuraOrg;
	}

	public void setEstructuraOrg(EstructuraOrg estructuraOrg) {
		this.estructuraOrg = estructuraOrg;
	}

	@Override
	public String toString() {
		return "centroCosto=" + centroCosto.getId() + ", estructuraOrg=" + estructuraOrg.getId();
	}
	
	
	
}
