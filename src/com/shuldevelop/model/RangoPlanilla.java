package com.shuldevelop.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity(name = "RANGO_PLANILLA")
@Table(name = "RANGO_PLANILLA")

@AssociationOverrides({
  @AssociationOverride(name = "id.planillaEmpleado", joinColumns = @JoinColumn(name = "id_planilla_empleado")),
  @AssociationOverride(name = "id.rangoComision", joinColumns = @JoinColumn(name = "id_rango_comision")) 
 })
public class RangoPlanilla {

	@EmbeddedId
	private RangoPlanillaId id = new RangoPlanillaId();
	
    @Column(name = "venta")
    private double venta;

	public RangoPlanilla(RangoPlanillaId id, double venta) {
		this.id = id;
		this.venta = venta;
	}

	public RangoPlanilla() {
	}

	public RangoPlanillaId getId() {
		return id;
	}

	public void setId(RangoPlanillaId id) {
		this.id = id;
	}

	public double getVenta() {
		return venta;
	}

	public void setVenta(double venta) {
		this.venta = venta;
	}
    
	public EmpleadoPlanilla getEmpleadoPlanilla() {
		return getId().getPlanillaEmpleado();
	}
	
	public void setEmpleadoPlanilla(EmpleadoPlanilla empleadoPlanilla) {
		getId().setPlanillaEmpleado(empleadoPlanilla);
	}
	
	public RangoComision getRangoComision() {
		return getId().getRangoComision();
	}
	
	public void setRangoComision(RangoComision rangoComision) {
		getId().setRangoComision(rangoComision);
	}
}
