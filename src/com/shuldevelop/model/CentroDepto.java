package com.shuldevelop.model;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity(name="CENTRO_DEPTO")
@Table(name="CENTRO_DEPTO")

@AssociationOverrides({
	@AssociationOverride(name="id.centroCosto",joinColumns=@JoinColumn(name="id_centro_costo")),
	@AssociationOverride(name="id.estructuraOrg",joinColumns=@JoinColumn(name="id_estructura_org")),
})

public class CentroDepto {
	@EmbeddedId
	private CentroDeptoPK id = new CentroDeptoPK();
	
	@Column(name="anio")
	private int anio;

	public CentroDeptoPK getId() {
		return id;
	}

	public void setId(CentroDeptoPK id) {
		this.id = id;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public CentroCosto getCentroCosto() {
		return getId().getCentroCosto();
	}
	
	public void setCentroCosto(CentroCosto centroCosto) {
		getId().setCentroCosto(centroCosto);
	}
	
	public EstructuraOrg getEstructuraOrg() {
		return getId().getEstructuraOrg();
	}
	
	public void setEstructuraOrg(EstructuraOrg estructuraOrg) {
		getId().setEstructuraOrg(estructuraOrg);
	}

	@Override
	public String toString() {
		return "CentroDepto [id=" + id + ", anio=" + anio + "]";
	}
	
	
	
}
