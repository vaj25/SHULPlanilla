package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "UNIDAD_ORGANIZACIONAL")
@Table(name = "UNIDAD_ORGANIZACIONAL")
public class UnidadOrganizacional {
		
	@Id
	@Column(name = "id_unidad_org")
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_UNIDAD_ORG",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	private int id;

	@Column
	private String unidad_org;
	
	@Column
	private String direccion;
	
	@Column
	private String representante;
	
	@Column
	private String nit;
	
	@Column
	private int nic;
	
	@Column
	private int telefono;
	
	@Column
	private String email_pers;
	
	@Column
	private String site_web;

	public UnidadOrganizacional() {
		
	}

	public UnidadOrganizacional(int id, String unidad_org, String direccion, String representante, String nit, int nic,
			int telefono, String email_pers, String site_web) {
		super();
		this.id = id;
		this.unidad_org = unidad_org;
		this.direccion = direccion;
		this.representante = representante;
		this.nit = nit;
		this.nic = nic;
		this.telefono = telefono;
		this.email_pers = email_pers;
		this.site_web = site_web;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnidad_org() {
		return unidad_org;
	}

	public void setUnidad_org(String unidad_org) {
		this.unidad_org = unidad_org;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public int getNic() {
		return nic;
	}

	public void setNic(int nic) {
		this.nic = nic;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail_pers() {
		return email_pers;
	}

	public void setEmail_pers(String email_pers) {
		this.email_pers = email_pers;
	}

	public String getSite_web() {
		return site_web;
	}

	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}

	@Override
	public String toString() {
		return unidad_org;
	}
	
	
	
}
