package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "TIPO_INGRESO")
@Table(name = "TIPO_INGRESO")
public class TipoIngreso {

	@Id
	@Column(name = "id_tipo_ingreso")
	@SequenceGenerator(name = "SequenceIdTipoIngreso", sequenceName = "SEQ_TIPO_INGRESO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdTipoIngreso")
	private int id;
	
	@Column(name = "tipo_ingreso")
	private String tipoIngreso;

	public TipoIngreso() {
	}

	public TipoIngreso(int id, String tipoIngreso) {
		this.id = id;
		this.tipoIngreso = tipoIngreso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}
	
}
