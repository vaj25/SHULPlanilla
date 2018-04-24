package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "ESTADO_CIVIL")
@Table(name = "ESTADO_CIVIL")
public class EstadoCivil {

	@Id
	@Column(name = "id_estado_civil")
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_ESTADO_CIVIL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	private int id;
	
	
	@Column(name = "estado_civil")
	private String estadoCivil;
	
	public EstadoCivil() {
	}

	public EstadoCivil(String estadoCivil) {
		super();
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
