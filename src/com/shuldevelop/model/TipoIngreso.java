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

@Entity(name = "TIPO_INGRESO")
@Table(name = "TIPO_INGRESO")
public class TipoIngreso {

	@Id
	@Column(name = "id_tipo_ingreso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_INGRESO")
	@SequenceGenerator(name = "SEQ_TIPO_INGRESO", sequenceName = "SEQ_TIPO_INGRESO", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "tipo_ingreso")
	private String tipoIngreso;
	
	@Transient 
	@OneToMany(mappedBy = "tipoIngreso")
	private List<RangoComision> rangoComision;
	
	@Transient
	@OneToMany(mappedBy = "id.tipoIngreso")
    	private List<IngresoPlanilla> ingresoPlanilla = new ArrayList<>();

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

	public List<RangoComision> getRangoComision() {
		return rangoComision;
	}

	public void setRangoComision(List<RangoComision> rangoComision) {
		this.rangoComision = rangoComision;
	}

	public List<IngresoPlanilla> getIngresoPlanilla() {
		return ingresoPlanilla;
	}

	public void setIngresoPlanilla(List<IngresoPlanilla> ingresoPlanilla) {
		this.ingresoPlanilla = ingresoPlanilla;
	}

	@Override
	public String toString() {
		return tipoIngreso;
	}
	
}
