package com.shuldevelop.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RangoPlanillaId {
	
	@ManyToOne
//	@JoinColumn(name = "id_planilla_empleado")
    private EmpleadoPlanilla planillaEmpleado;
 
	@ManyToOne
//	@JoinColumn(name = "id_rango_comision")
    private RangoComision rangoComision;

	public EmpleadoPlanilla getPlanillaEmpleado() {
		return planillaEmpleado;
	}

	public void setPlanillaEmpleado(EmpleadoPlanilla planillaEmpleado) {
		this.planillaEmpleado = planillaEmpleado;
	}

	public RangoComision getRangoComision() {
		return rangoComision;
	}

	public void setRangoComision(RangoComision rangoComision) {
		this.rangoComision = rangoComision;
	}
	
}
