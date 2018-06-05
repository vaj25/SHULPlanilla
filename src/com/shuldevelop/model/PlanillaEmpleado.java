package com.shuldevelop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity(name = "PLANILLA_EMPLEADO")
@Table(name = "PLANILLA_EMPLEADO")
public class PlanillaEmpleado {

	@Id
	@Column(name = "id_PLANILLA_EMPLEADO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANILLA_EMPLEADO")
	@SequenceGenerator(name = "SEQ_PLANILLA_EMPLEADO", sequenceName = "SEQ_PLANILLA_EMPLEADO", allocationSize = 1, initialValue = 1)
	private int id;


	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_empleado")
	private Empleado empleado;

	public PlanillaEmpleado() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
