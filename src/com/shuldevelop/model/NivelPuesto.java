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

@Entity(name = "NIVEL_PUESTO")
@Table(name = "NIVEL_PUESTO")
public class NivelPuesto {
	
	@Id
	@Column(name = "id_nivel_puesto")
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_NIVEL_PUESTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	private int id;
	
	@Column(name = "numero_nivel")
	private int numeroNivel;
	
	@Column
	private double salario;
	
	@OneToMany(mappedBy = "nivelPuesto")
    private List<Puesto> puesto = new ArrayList<>();
	
	public NivelPuesto() {
		super();
	}

	public NivelPuesto(int id, int numeroNivel, double salario) {
		super();
		this.id = id;
		this.numeroNivel = numeroNivel;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroNivel() {
		return numeroNivel;
	}

	public void setNumeroNivel(int numeroNivel) {
		this.numeroNivel = numeroNivel;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<Puesto> getPuesto() {
		return puesto;
	}

	public void setPuesto(List<Puesto> puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return numeroNivel + " - $" + String.format("%.2f", salario);
	}
	
}
