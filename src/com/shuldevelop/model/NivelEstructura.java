package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "NIVEL_ESTRUCTURA")
@Table(name = "NIVEL_ESTRUCTURA")
public class NivelEstructura {
	@Id
	@Column(name = "id_nivel_estructura")
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_NIVEL",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	private int id;
	
	@Column
	private String nombre_nivel;
	
	@Column
	private int numero_nivel;

	public NivelEstructura() {
		
	}

	public NivelEstructura(String nombre_nivel) {
		super();
		this.nombre_nivel = nombre_nivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_nivel() {
		return nombre_nivel;
	}

	public void setNombre_nivel(String nombre_nivel) {
		this.nombre_nivel = nombre_nivel;
	}

	public int getNumero_nivel() {
		return numero_nivel;
	}

	public void setNumero_nivel(int numero_nivel) {
		this.numero_nivel = numero_nivel;
	}

	
	
	
	
	
	
}
