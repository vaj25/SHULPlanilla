package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PERMISO")
@Table(name = "PERMISO")
public class Permiso {

	@Id
	@Column(name = "id_permiso")
	private int id;
	
	@Column(name = "permiso")
	private String permiso;

	
	public Permiso() {
	}

	public Permiso(int id, String permiso) {
		this.id = id;
		this.permiso = permiso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	@Override
	public String toString() {
		return permiso;
	}
	
}
