package com.shuldevelop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "DEPARTAMENTO")
@Table(name = "DEPARTAMENTO")
public class Departamento {

	@Id
	@Column(name = "id_departamento")
	private int id;
	
	@Column(name= "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_est_territorial")
	private Zona zona;
	
	@Transient
	@OneToMany(mappedBy = "departamento")
    private List<Municipio> municipio = new ArrayList<>();

	public Departamento() {
	}

	public Departamento(int id, String nombre, Zona zona) {
		this.id = id;
		this.nombre = nombre;
		this.zona = zona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Departamento: " + nombre;
	}
	
}
