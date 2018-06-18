package com.shuldevelop.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity(name = "PLANILLA")
@Table(name = "PLANILLA")
public class Planilla {

	@Id
	@Column(name = "id_planilla")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANILLA")
	@SequenceGenerator(name = "SEQ_PLANILLA", sequenceName = "SEQ_PLANILLA", allocationSize = 1, initialValue = 1)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio ;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column(name = "estado_planilla")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean estado;

	public Planilla() {
	}

	public Planilla(int id, Date fechaInicio, Date fechaFin) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String formatearFecha(Date fecha){
		return new SimpleDateFormat("dd-MM-yyyy").format(fecha);
	}

}
