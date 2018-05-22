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

@Entity(name = "PLANILLA_EMPLEADO")
@Table(name = "PLANILLA_EMPLEADO")
public class EmpleadoPlanilla {

	@Id
	@Column(name = "id_planilla_empleado")
	@SequenceGenerator(name = "SequenceIdPlanillaEmpleado", sequenceName = "SEQ_PLANILLA_EMPLEADO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdPlanillaEmpleado")
	public int id;
	
	@OneToMany(mappedBy = "id.empleadoPlanilla")
    private List<RangoPlanilla> rangoPlanilla = new ArrayList<>();
	
	public EmpleadoPlanilla() {
	}

	public EmpleadoPlanilla(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
