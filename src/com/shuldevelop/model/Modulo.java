package com.shuldevelop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "MODULO")
@Table(name = "MODULO")
public class Modulo {

	@Id
	@Column(name = "id_modulo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MODULO")
	@SequenceGenerator(name = "SEQ_MODULO", sequenceName = "SEQ_MODULO", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "nombre_modulo")
	private String nombre;
	
	@Column(name = "descripcion_modulo")
	private String descripcion;
	
	@Column(name = "orden")
	private int orden;
	
	@Column(name = "url_modulo")
	private String url;
	
	@Column(name = "img_modulo")
	private String icono;
	
	@Column(name = "opciones_modulo")
	private int opciones;
	
	@ManyToOne
	@JoinColumn(name = "dependencia")
	private Modulo dependencia;
	
	@OneToMany(mappedBy = "dependencia")
	private List<Modulo> modulos = new ArrayList<>();

	public Modulo() {
	}

	public Modulo(int id, String nombre, String descripcion, int orden, String url, String icono, int opciones,
			Modulo dependencia) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.orden = orden;
		this.url = url;
		this.icono = icono;
		this.opciones = opciones;
		this.dependencia = dependencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public int getOpciones() {
		return opciones;
	}

	public void setOpciones(int opciones) {
		this.opciones = opciones;
	}

	public Modulo getDependencia() {
		return dependencia;
	}

	public void setDependencia(Modulo dependencia) {
		this.dependencia = dependencia;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
}
