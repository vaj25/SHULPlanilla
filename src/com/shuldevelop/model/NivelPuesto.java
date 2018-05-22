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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NIVEL_PUESTO")
	@SequenceGenerator(name = "SEQ_NIVEL_PUESTO", sequenceName = "SEQ_NIVEL_PUESTO", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "numero_nivel")
	private int numeroNivel;
	
	@Column(name = "salario_minimo")
	private double salarioMinimo;
	
	@Column(name = "salario_maximo")
	private double salarioMaximo;
	
	@OneToMany(mappedBy = "nivelPuesto")
    private List<Puesto> puesto = new ArrayList<>();
	
	public NivelPuesto() {
		super();
	}

	public NivelPuesto(int id, int numeroNivel, double salarioMinimo, List<Puesto> puesto) {
		this.id = id;
		this.numeroNivel = numeroNivel;
		this.salarioMinimo = salarioMinimo;
		this.puesto = puesto;
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

	public double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public double getSalarioMaximo() {
		return salarioMaximo;
	}

	public void setSalarioMaximo(double salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

	public List<Puesto> getPuesto() {
		return puesto;
	}

	public void setPuesto(List<Puesto> puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return this.numeroNivel + " - $" + String.format("%.2f", this.salarioMinimo)
				+ " - $" + String.format("%.2f", this.salarioMaximo);
	}
	
}
