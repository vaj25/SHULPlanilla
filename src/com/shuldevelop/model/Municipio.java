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

@Entity(name = "MUNICIPIO")
@Table(name = "MUNICIPIO")
public class Municipio {

	@Id
	@Column(name = "id_municipio")
	private int id;
	
	@Column(name = "municipio")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "municipio")
    private List<Direccion> direccion = new ArrayList<>();

	public Municipio() {
	}

	public Municipio(int id, String nombre, Departamento departamento) {
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Municipio: " + nombre;
	}
	
}
