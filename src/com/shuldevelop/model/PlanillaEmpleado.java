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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANILLA_EMPLEADO")
	@SequenceGenerator(name = "SEQ_PLANILLA_EMPLEADO", sequenceName = "SEQ_PLANILLA_EMPLEADO", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "id_empleado")
	private String idEmpleado;
	
	@Column(name = "id_tipo_descuento")
	private int idTipoDescuento;

	public PlanillaEmpleado() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdTipoDescuento() {
		return idTipoDescuento;
	}

	public void setIdTipoDescuento(int idTipoDescuento) {
		this.idTipoDescuento = idTipoDescuento;
	}

}
