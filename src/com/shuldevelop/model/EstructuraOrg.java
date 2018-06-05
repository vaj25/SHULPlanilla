package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.ManyToOne;


@Entity(name="ESTRUCTURA_ORG")
@Table(name = "ESTRUCTURA_ORG")
public class EstructuraOrg{
	
		@Id
		@OnDelete(action = OnDeleteAction.CASCADE)
		@Column(name= "id_estructura_org")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTRUCTURA_ORG")
        @SequenceGenerator(name = "SEQ_ESTRUCTURA_ORG", sequenceName = "SEQ_ESTRUCTURA_ORG", allocationSize = 1, initialValue = 1)
		private int id;
		 
		@Column(name="nombre")
		private String nombre;
		 
		@ManyToOne
		@JoinColumn(name = "id_unidad_org")
		private UnidadOrganizacional unidadOrganizacional;
		
		@ManyToOne
		@JoinColumn(name = "id_nivel_estructura")
		private NivelEstructura nivelEstructura;		

		@ManyToOne
		@JoinColumn(name = "est_id_estructura_org")
		private EstructuraOrg estEstructuraOrg;
		
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
		

		public UnidadOrganizacional getUnidadOrganizacional() {
			return unidadOrganizacional;
		}

		public void setUnidadOrganizacional(UnidadOrganizacional unidadOrganizacional) {
			this.unidadOrganizacional = unidadOrganizacional;
		}

		public NivelEstructura getNivelEstructura() {
			return nivelEstructura;
		}

		public void setNivelEstructura(NivelEstructura nivelEstructura) {
			this.nivelEstructura = nivelEstructura;
		}
		
		public EstructuraOrg getEstEstructuraOrg() {
			return estEstructuraOrg;
		}

		public void setEstEstructuraOrg(EstructuraOrg estEstructuraOrg) {
			this.estEstructuraOrg = estEstructuraOrg;
		}

		@Override
		public String toString() {
			return nombre;
		}
		
		

		

	
	 
	}
