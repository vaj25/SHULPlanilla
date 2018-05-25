package com.shuldevelop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class IngresoPlanillaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    private PlanillaEmpleado planillaEmpleado;
 
	@ManyToOne
    private TipoIngreso tipoIngreso;

	public PlanillaEmpleado getPlanillaEmpleado() {
		return planillaEmpleado;
	}

	public void setPlanillaEmpleado(PlanillaEmpleado planillaEmpleado) {
		this.planillaEmpleado = planillaEmpleado;
	}

	public TipoIngreso getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(TipoIngreso tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}

}
