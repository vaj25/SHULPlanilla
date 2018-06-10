		package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "INFO_LABORAL_EMPLEADO")
@Table(name = "INFO_LABORAL_EMPLEADO")
public class InfoLaboralEmpleado {


	@Id
	@Column(name = "id_info_laboral_empleado")
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_INFO_LABORAL_EMPLEADO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	private int id;	
	
	@Column(name="salario")
	private double salario;
	
	@ManyToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_empleado")
	private TipoEmpleado tipoEmpleado;
	
	@ManyToOne
	@JoinColumn(name="id_estructura_org")
	private EstructuraOrg estructuraOrg;
	
	@ManyToOne
	@JoinColumn(name="id_puesto")
	private Puesto puesto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public EstructuraOrg getEstructuraOrg() {
		return estructuraOrg;
	}

	public void setEstructuraOrg(EstructuraOrg estructuraOrg) {
		this.estructuraOrg = estructuraOrg;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "InfoLaboralEmpleado [id=" + id + ", salario=" + salario + ", empleado=" + empleado + ", tipoEmpleado="
				+ tipoEmpleado + ", estructuraOrg=" + estructuraOrg + ", puesto=" + puesto + "]";
	}
	
	
}
