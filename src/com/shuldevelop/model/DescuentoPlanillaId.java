package com.shuldevelop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DescuentoPlanillaId implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    private PlanillaEmpleado planillaEmpleado;

	@ManyToOne
    private TipoDescuento tipoDescuento;

	public DescuentoPlanillaId() {
	}

	public DescuentoPlanillaId(PlanillaEmpleado planillaEmpleado, TipoDescuento tipoDescuento) {
		this.planillaEmpleado = planillaEmpleado;
		this.tipoDescuento = tipoDescuento;
	}

	public PlanillaEmpleado getPlanillaEmpleado() {
		return planillaEmpleado;
	}

	public void setPlanillaEmpleado(PlanillaEmpleado planillaEmpleado) {
		this.planillaEmpleado = planillaEmpleado;
	}

	public TipoDescuento getTipoDescuento() {
		return tipoDescuento;
	}

	public void setTipoDescuento(TipoDescuento tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}

}
