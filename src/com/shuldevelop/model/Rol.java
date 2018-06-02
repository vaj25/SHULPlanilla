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

@Entity(name = "ROL")
@Table(name = "ROL")
public class Rol {

	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROL")
	@SequenceGenerator(name = "SEQ_ROL", sequenceName = "SEQ_ROL", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "rol", nullable = false)
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "rol")
    private List<Usuario> usuario = new ArrayList<>();
	
	@OneToMany(mappedBy = "rol")
    private List<RolModuloPermiso> rolModuloPermisos = new ArrayList<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombreRol) {
		nombre = nombreRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<RolModuloPermiso> getRolModuloPermisos() {
		return rolModuloPermisos;
	}

	public void setRolModuloPermisos(List<RolModuloPermiso> rolModuloPermisos) {
		this.rolModuloPermisos = rolModuloPermisos;
	}

	public String toString() {
		return this.nombre;
	}
	
}
