package com.shuldevelop.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity(name = "INGRESO_PLANILLA")
@Table(name = "INGRESO_PLANILLA")

@AssociationOverrides({
	  @AssociationOverride(name = "id.planillaEmpleado", joinColumns = @JoinColumn(name = "id_planilla_empleado")),
	  @AssociationOverride(name = "id.tipoIngreso", joinColumns = @JoinColumn(name = "id_tipo_ingreso")) 
})
public class IngresoPlanilla {
	
	@EmbeddedId
	private IngresoPlanillaId id;
	
	@Column(name = "monto")
    private double monto;

	public IngresoPlanilla(IngresoPlanillaId id, double monto) {
		this.id = id;
		this.monto = monto;
	}

	public IngresoPlanilla() {
	}

	public IngresoPlanillaId getId() {
		return id;
	}

	public void setId(IngresoPlanillaId id) {
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
	
	public TipoIngreso getTipoIngreso() {
		return getId().getTipoIngreso();
	}
	
	public void setTipoIngreso(TipoIngreso tipoIngreso) {
		getId().setTipoIngreso(tipoIngreso);
	}
	
}
