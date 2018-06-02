package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "RANGO_RENTA")
@Table(name = "RANGO_RENTA")

public class RangoRenta {

	@Id
	@Column(name = "id_rango_renta")	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RANGO_RENTA")
	@SequenceGenerator(name = "SEQ_RANGO_RENTA", sequenceName = "SEQ_RANGO_RENTA", allocationSize = 1, initialValue = 1)
	private int id;

	@Column(name = "desde")
	private double desde;

	@Column(name = "hasta")
	private double hasta;

	@Column(name = "periodo")
	private int periodo;

	@Column(name = "cuota_fija")
	private double cuota;

	@Column(name = "taza")
	private double taza;

	public RangoRenta() {
	}

	public RangoRenta(int id, double desde, double hasta, int periodo, double cuota, double taza) {
		this.id = id;
		this.desde = desde;
		this.hasta = hasta;
		this.periodo = periodo;
		this.cuota = cuota;
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

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getTaza() {
		return taza;
	}

	public void setTaza(double taza) {
		this.taza = taza;
	}

}
