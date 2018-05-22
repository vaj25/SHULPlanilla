package com.shuldevelop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RangoPlanillaId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
//	@JoinColumn(name = "id_planilla_empleado")
    private PlanillaEmpleado planillaEmpleado;
 
	@ManyToOne
//	@JoinColumn(name = "id_rango_comision")
    private RangoComision rangoComision;

	public PlanillaEmpleado getPlanillaEmpleado() {
		return planillaEmpleado;
	}

	public void setPlanillaEmpleado(PlanillaEmpleado planillaEmpleado) {
		this.planillaEmpleado = planillaEmpleado;
	}

	public RangoComision getRangoComision() {
		return rangoComision;
	}

	public void setRangoComision(RangoComision rangoComision) {
		this.rangoComision = rangoComision;
	}
	
}
