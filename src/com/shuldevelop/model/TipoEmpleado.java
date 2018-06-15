package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "TIPO_EMPLEADO")
@Table(name = "TIPO_EMPLEADO")
public class TipoEmpleado {

	@Id
	@Column(name="id_tipo_empleado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_EMPLEADO")
	@SequenceGenerator(name = "SEQ_TIPO_EMPLEADO", sequenceName = "SEQ_TIPO_EMPLEADO", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name="tipo_empleado")
	private String tipo_empleado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo_empleado() {
		return tipo_empleado;
	}

	public void setTipo_empleado(String tipo_empleado) {
		this.tipo_empleado = tipo_empleado;
	}

	@Override
	public String toString() {
		return tipo_empleado;
	}
	
}
