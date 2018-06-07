package com.shuldevelop.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity(name = "DESCUENTO_PLANILLA")
@Table(name = "DESCUENTO_PLANILLA")

@AssociationOverrides({
	  @AssociationOverride(name = "id.planillaEmpleado", joinColumns = @JoinColumn(name = "id_planilla_empleado")),
	  @AssociationOverride(name = "id.tipoDescuento", joinColumns = @JoinColumn(name = "id_tipo_descuento"))
})
public class DescuentoPlanilla {

	@EmbeddedId
	private DescuentoPlanillaId id;

	@Column(name = "monto_descuento")
    private double monto;

	public DescuentoPlanilla(DescuentoPlanillaId id, double monto) {
		this.id = id;
		this.monto = monto;
	}

	public DescuentoPlanilla() {
	}

	public DescuentoPlanillaId getId() {
		return id;
	}

	public void setId(DescuentoPlanillaId id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public PlanillaEmpleado getPlanillaEmpleado() {
		return getId().getPlanillaEmpleado();
	}

	public void setPlanillaEmpleado(PlanillaEmpleado planillaEmpleado) {
		getId().setPlanillaEmpleado(planillaEmpleado);
	}

	public TipoDescuento getTipoDescuento() {
		return getId().getTipoDescuento();
	}

	public void setTipoDescuento(TipoDescuento tipoDescuento) {
		getId().setTipoDescuento(tipoDescuento);
	}

}
