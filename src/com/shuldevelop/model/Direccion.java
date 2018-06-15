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

@Entity(name = "DIRECCION")
@Table(name = "DIRECCION")
public class Direccion {

	@Id
	@Column(name = "id_direccion")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DIRECCION")
	@SequenceGenerator(name = "SEQ_DIRECCION", sequenceName = "SEQ_DIRECCION", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "num_casa")
	private String numCasa;
	
	@Column(name = "num_calle")
	private String numCalle;
	
	@Column(name = "colonia")
	private String colonia;
	
	@Column(name = "avenida")
	private String avenida;
	
	@Column(name = "poligono")
	private String poligono;
	
	@Column(name = "pasaje")
	private String pasaje;
	
	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;
	
	public Direccion() {
	}

	public Direccion(int id, String numCasa, String numCalle, String colonia, String avenida, String poligono,
			String pasaje, Municipio municipio) {
		this.id = id;
		this.numCasa = numCasa;
		this.numCalle = numCalle;
		this.colonia = colonia;
		this.avenida = avenida;
		this.poligono = poligono;
		this.pasaje = pasaje;
		this.municipio = municipio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}

	public String getNumCalle() {
		return numCalle;
	}

	public void setNumCalle(String numCalle) {
		this.numCalle = numCalle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getAvenida() {
		return avenida;
	}

	public void setAvenida(String avenida) {
		this.avenida = avenida;
	}

	public String getPoligono() {
		return poligono;
	}

	public void setPoligono(String poligono) {
		this.poligono = poligono;
	}

	public String getPasaje() {
		return pasaje;
	}

	public void setPasaje(String pasaje) {
		this.pasaje = pasaje;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {
		
		String direccion = "";
		
		
		if (this.pasaje != "") {
			direccion += "Pasaje " + this.pasaje;
		}
		
		if (this.colonia != "") {
			direccion += ", Colonia " + this.colonia;
		}
		
		if (this.numCalle != "") {
			direccion += ", " + this.numCalle;
		}
		
		if (this.avenida != "") {
			direccion += ", Avenida " + this.avenida;
		}
		
		if (this.poligono != "") {
			direccion += ", Poligono " + this.poligono;
		}
		
		if (this.poligono != "") {
			direccion += ", Casa " + this.numCasa;
		}
		
		return direccion;
	}
		
}
