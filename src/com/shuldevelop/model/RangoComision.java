package com.shuldevelop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private double tasa;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_ingreso")
	private TipoIngreso tipoIngreso;
	
	@Transient
	@OneToMany(mappedBy = "id.rangoComision")
    private List<RangoPlanilla> rangoPlanilla = new ArrayList<>();
	
	public RangoComision() {
	}

	public RangoComision(int id, double desde, double hasta, double tasa, TipoIngreso tipoIngreso) {
		this.id = id;
		this.desde = desde;
		this.hasta = hasta;
		this.tasa = tasa;
		this.tipoIngreso = tipoIngreso;
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

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public TipoIngreso getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(TipoIngreso tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}
	
}
