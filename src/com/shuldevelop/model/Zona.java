package com.shuldevelop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "ZONA")
@Table(name = "ZONA")
public class Zona {

	@Id
	@Column(name = "id_est_territorial")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ZONA")
	@SequenceGenerator(name = "SEQ_ZONA", sequenceName = "SEQ_ZONA", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "zona")
	private String zona;

	@Transient 
	@OneToMany(mappedBy = "zona")
	private List<Departamento> departamento;
	
	public Zona() {
	}

	public Zona(int id, String zona) {
		this.id = id;
		this.zona = zona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Zona: " + zona;
	}
	
}
