package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "TIPO_DOC_IDENTIDAD")
@Table(name = "TIPO_DOC_IDENTIDAD")
public class TipoDocIdentidad {

	@Id
	@Column(name = "id_tipo_doc_identidad")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEQUENCENAME")
	@SequenceGenerator(name = "SEQ_SEQUENCENAME", sequenceName = "SEQ_SEQUENCENAME", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column
	private String tipo;
	
	public TipoDocIdentidad() {
	}

	public TipoDocIdentidad(String tipo) {
		super();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return tipo;
	}
}
