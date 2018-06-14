package com.shuldevelop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name = "empleados")
public class EmpleadoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_empleado")
	private String idEmpleado;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "estado_civil")
	private String estadoCivil;
	
	@Column(name = "fecha_nacimiento")
	private String fechaNacimiento;
	
	@Column(name = "isss")
	private String isss;
	
	@Column(name = "nit")
	private String nit;
	
	@Column(name = "nup")
	private String nup;
	
	@Column(name = "fecha_ingreso")
	private String fechaIngreso;
	
	@Column(name = "puesto")
	private String Puesto;
	
	@Column(name = "tipo_empleado")
	private String tipoEmpleado;
	
	@Column(name = "id_puesto")
	private String idPuesto;
	
	@Column(name = "oficio")
	private String oficio;
	
	@Column(name = "nivel_puesto")
	private String nivelPuesto;
	
	@Column(name = "id_centro_costo")
	private String centroCosto;
	
	@Column(name = "id_estructura_org")
	private String estructuraOrg;
	
	@Column(name = "nombre_est_org")
	private String nombreEstOrg;
	
	@Column(name = "salario")
	private String salario;
	
	@Column(name = "id_jefe")
	private String idJefe;
	
	@Column(name = "nombre_jefe")
	private String nombreJefe;

	public EmpleadoView() {
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public String getGenero() {
		return genero;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getIsss() {
		return isss;
	}

	public String getNit() {
		return nit;
	}

	public String getNup() {
		return nup;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public String getPuesto() {
		return Puesto;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public String getIdPuesto() {
		return idPuesto;
	}

	public String getOficio() {
		return oficio;
	}

	public String getNivelPuesto() {
		return nivelPuesto;
	}

	public String getCentroCosto() {
		return centroCosto;
	}

	public String getEstructuraOrg() {
		return estructuraOrg;
	}

	public String getNombreEstOrg() {
		return nombreEstOrg;
	}

	public String getSalario() {
		return salario;
	}

	public String getIdJefe() {
		return idJefe;
	}

	public String getNombreJefe() {
		return nombreJefe;
	}
		
}
