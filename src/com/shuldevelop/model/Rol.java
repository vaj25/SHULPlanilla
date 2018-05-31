package com.shuldevelop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "ROL")
@Table(name = "ROL")
public class Rol {

	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROL")
	@SequenceGenerator(name = "SEQ_ROL", sequenceName = "SEQ_ROL", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "rol", nullable = false)
	private String NombreRol;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "rol")
    private List<Usuario> usuario = new ArrayList<>();

	public String getNombreRol() {
		return NombreRol;
	}

	public void setNombreRol(String nombreRol) {
		NombreRol = nombreRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return this.NombreRol;
	}
	
}
