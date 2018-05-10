package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PLANILLA_EMPLEADO")
@Table(name = "PLANILLA_EMPLEADO")
public class PlanillaEmpleado {

	@Id
	@Column(name = "id_PLANILLA_EMPLEADO")
	/*@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_PLANILLA_EMPLEADO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	*/

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANILLA_EMPLEADO")
	@SequenceGenerator(name = "SEQ_PLANILLA_EMPLEADO", sequenceName = "SEQ_PLANILLA_EMPLEADO", allocationSize = 1, initialValue = 1)


	private int id;


	@Column(name = "VENTA")
	private Float venta;

	public PlanillaEmpleado() {
	}

	public PlanillaEmpleado(Float venta) {
		super();
		this.venta = venta;
	}

	public Float getVenta() {
		return venta;
	}

	public void setVenta(Float venta) {
		this.venta = venta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
