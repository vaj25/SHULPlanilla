package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "TIPO_DESCUENTO")
@Table(name = "TIPO_DESCUENTO")
public class TipoDescuento {

	@Id
	@Column(name = "id_tipo_descuento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_DESCUENTO")
	@SequenceGenerator(name = "SEQ_TIPO_DESCUENTO", sequenceName = "SEQ_TIPO_DESCUENTO", allocationSize = 1, initialValue = 1)
	private int id;

	@Column(name = "tipo_descuento")
	private String tipo ;

	@Column(name = "taza")
	private double taza;

	public TipoDescuento() {
	}

	public TipoDescuento(int id, String tipo, double taza) {
		this.id = id;
		this.tipo = tipo;
		this.taza = taza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTaza() {
		return taza;
	}

	public void setTaza(double taza) {
		this.taza = taza;
	}

}
