package com.shuldevelop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity(name = "GENERO")
@Table(name = "GENERO")
public class Genero {

		@Id
		@Column(name = "id_genero")
		@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "SEQ_GENERO")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
		private int id;
		
		@Column
		private String genero;
		
		public Genero() {
		}

		public Genero(String genero) {
			super();
			this.genero = genero;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
	

	
	
}
