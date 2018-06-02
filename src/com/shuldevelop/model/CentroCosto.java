package com.shuldevelop.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity(name= "CENTRO_COSTO")
@Table(name = "CENTRO_COSTO")
public class CentroCosto{
	@Id
	@Column(name="id_centro_costo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CENTRO_COSTO")
	@SequenceGenerator(name = "SEQ_CENTRO_COSTO", sequenceName = "SEQ_CENTRO_COSTO", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name="monto")
	private double monto;
	
	@Column(name="periodicidad")
	private String periodicidad;
	
	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	public List<CentroDepto> getCentroDepto() {
		return centroDepto;
	}

	public void setCentroDepto(List<CentroDepto> centroDepto) {
		this.centroDepto = centroDepto;
	}

	@Transient
	@OneToMany(mappedBy = "id.centroCosto")
	private List<CentroDepto> centroDepto = new ArrayList<>();
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	public CentroCosto() {
	}
	
	public CentroCosto(int id, double monto,String periodicidad) {
		this.id = id;
		this.monto = monto;
		this.periodicidad = periodicidad;
	}

	@Override
	public String toString() {
		return "CentroCosto [id=" + id + ", monto=" + monto + ", periodicidad=" + periodicidad + ", centroDepto="
				+ centroDepto + "]";
	}
	
	
	
	
}
