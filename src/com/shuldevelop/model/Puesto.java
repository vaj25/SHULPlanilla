package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PUESTO")
@Table(name = "PUESTO")
public class Puesto {
	
	@Id
	@Column(name = "id_puesto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUESTO")
	@SequenceGenerator(name = "SEQ_PUESTO", sequenceName = "SEQ_PUESTO", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "puesto")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_nivel_puesto")
	private NivelPuesto nivelPuesto;

	public Puesto() {
	}

	public Puesto(int id, String nombre, NivelPuesto nivelPuesto) {
		this.id = id;
		this.nombre = nombre;
		this.nivelPuesto = nivelPuesto;
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

	public NivelPuesto getNivelPuesto() {
		return nivelPuesto;
	}

	public void setNivelPuesto(NivelPuesto nivelPuesto) {
		this.nivelPuesto = nivelPuesto;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
	
}
