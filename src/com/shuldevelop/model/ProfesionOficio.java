package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PROFESION_OFICIO")
@Table(name = "PROFESION_OFICIO")

public class ProfesionOficio {
	@Id
	@Column(name = "id_profesion_oficio")
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_OFICIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	private int id;
	
	@Column
	private String profesion_oficio;
	
	public ProfesionOficio() {}

	public ProfesionOficio(String profesion_oficio) {
		super();
		this.profesion_oficio = profesion_oficio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfesion_oficio() {
		return profesion_oficio;
	}

	public void setProfesion_oficio(String profesion_oficio) {
		this.profesion_oficio = profesion_oficio;
	}

	
	
	
	
	

}
