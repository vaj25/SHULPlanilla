package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity(name = "ROL_MODULO_PERMISO")
@Table(name = "ROL_MODULO_PERMISO")
public class RolModuloPermiso {

	@Id
	@Column(name = "id_rol_modulo_permiso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROL_MODULO_PERMISO")
	@SequenceGenerator(name = "SEQ_ROL_MODULO_PERMISO", sequenceName = "SEQ_ROL_MODULO_PERMISO", allocationSize = 1, initialValue = 1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "id_modulo")
	private Modulo modulo;
	
	@ManyToOne
	@JoinColumn(name = "id_permiso")
	private Permiso permiso;

	@Column(name = "estado")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean estado;
	
	public RolModuloPermiso() {
	}

	public RolModuloPermiso(int id, Rol rol, Modulo modulo, Permiso permiso, Boolean estado) {
		this.id = id;
		this.rol = rol;
		this.modulo = modulo;
		this.permiso = permiso;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
