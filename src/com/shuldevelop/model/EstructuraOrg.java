package com.shuldevelop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

@Entity(name="ESTRUCTURA_ORG")
@Table(name = "ESTRUCTURA_ORG")
public class EstructuraOrg{
	
		 @Id
		 @Column(name= "id_estructura_org")
		 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTRUCTURA_ORG")
         @SequenceGenerator(name = "SEQ_ESTRUCTURA_ORG", sequenceName = "SEQ_ESTRUCTURA_ORG", allocationSize = 1, initialValue = 1)
		 private int id;
		 
		 @Column(name="nombre")
		 private String nombre;
		 
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

		@Override
		public String toString() {
			return "EstructuraOrg [id=" + id + ", nombre=" + nombre + "]";
		}

		

	
	 
	}
