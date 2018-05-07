package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "RANGO_COMISION")
@Table(name = "RANGO_COMISION")
public class RangoComision {
	
	@Id
	@Column(name = "id_rango_comision")
	@SequenceGenerator(name = "SequenceIdRangoComision", sequenceName = "SEQ_RANGO_COMISION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdRangoComision")
	private int id;
	
	@Column(name = "desde")
	private double desde;
	
	@Column(name = "hasta")
	private double hasta;
	
	@Column(name = "taza")
	private double taza;
	
	public RangoComision() {
	}

	public RangoComision(int id, double desde, double hasta, double taza) {
		this.id = id;
		this.desde = desde;
		this.hasta = hasta;
		this.taza = taza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDesde() {
		return desde;
	}

	public void setDesde(double desde) {
		this.desde = desde;
	}

	public double getHasta() {
		return hasta;
	}

	public void setHasta(double hasta) {
		this.hasta = hasta;
	}

	public double getTaza() {
		return taza;
	}

	public void setTaza(double taza) {
		this.taza = taza;
	}
	
}
