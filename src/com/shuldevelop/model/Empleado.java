package com.shuldevelop.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="Empleado")
@Table(name="Empleado")
public class Empleado {

	@Id
	@Column(name="id_empleado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLEADO")
	@SequenceGenerator(name = "SEQ_EMPLEADO", sequenceName = "SEQ_EMPLEADO", allocationSize = 1, initialValue = 1)
	private int id;

	@Column(name="primer_nombre")
	private String primer_nombre;

	@Column(name="segundo_nombre")
	private String segundo_nombre;

	@Column(name="primer_apellido")
	private String primer_apellido;

	@Column(name="segundo_apellido")
	private String segundo_apellido;

	@Column(name="apellido_casada")
	private String apellido_casada;

	@Column(name="fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;

	@Column(name="fecha_ingreso")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_ingreso;

	@Column(name="nit")
	private String nit;

	@Column(name="isss")
	private int isss;

	@Column(name="nup")
	private long nup;
	
	@Column(name="doc_identidad")
	private String doc_identidad;

	@Column(name="email_pers")
	private String email_pers;

	@Column(name="email_inst")
	private String email_inst;
	
	@Column(name = "estado")
	private int estado;

	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_direccion")
	private Direccion direccion;

	@ManyToOne
	@JoinColumn(name="id_estado_civil")
	private EstadoCivil estadoCivil;


	@ManyToOne
	@JoinColumn(name="id_genero")
	private Genero genero;

	@ManyToOne
	@JoinColumn(name="id_tipo_doc_identidad")
	private TipoDocIdentidad tipoDocIdentidad;


	@ManyToOne
	@JoinColumn(name="id_profesion_oficio")
	private ProfesionOficio profesionOficio;

	@ManyToOne
	@JoinColumn(name="emp_id_empleado")
	private Empleado jefe;

	@OneToMany(mappedBy="jefe")
	private Set<Empleado> subordinado = new HashSet<Empleado>();

	public Empleado() {

	}

	public Empleado(int id, String primer_nombre, String segundo_nombre, String primer_apellido,
			String segundo_apellido, String apellido_casada, Date fecha_nacimiento, Date fecha_ingreso, String nit,
			int isss, long nup, String doc_identidad, String email_pers, String email_inst,int estado, Direccion direccion,
			EstadoCivil estadoCivil, Genero genero, TipoDocIdentidad tipoDocIdentidad, ProfesionOficio profesionOficio,
			Empleado jefe) {
		super();
		this.id = id;
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.apellido_casada = apellido_casada;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_ingreso = fecha_ingreso;
		this.nit = nit;
		this.isss = isss;
		this.nup = nup;
		this.doc_identidad = doc_identidad;
		this.email_pers = email_pers;
		this.email_inst = email_inst;
		this.estado = estado;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.genero = genero;
		this.tipoDocIdentidad = tipoDocIdentidad;
		this.profesionOficio = profesionOficio;
		this.jefe = jefe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public String getApellido_casada() {
		return apellido_casada;
	}

	public void setApellido_casada(String apellido_casada) {
		this.apellido_casada = apellido_casada;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public int getIsss() {
		return isss;
	}

	public void setIsss(int isss) {
		this.isss = isss;
	}

	public long getNup() {
		return nup;
	}

	public void setNup(long nup) {
		this.nup = nup;
	}

	public String getDoc_identidad() {
		return doc_identidad;
	}

	public void setDoc_identidad(String doc_identidad) {
		this.doc_identidad = doc_identidad;
	}

	public String getEmail_pers() {
		return email_pers;
	}

	public void setEmail_pers(String email_pers) {
		this.email_pers = email_pers;
	}

	public String getEmail_inst() {
		return email_inst;
	}

	public void setEmail_inst(String email_inst) {
		this.email_inst = email_inst;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public TipoDocIdentidad getTipoDocIdentidad() {
		return tipoDocIdentidad;
	}

	public void setTipoDocIdentidad(TipoDocIdentidad tipoDocIdentidad) {
		this.tipoDocIdentidad = tipoDocIdentidad;
	}

	public ProfesionOficio getProfesionOficio() {
		return profesionOficio;
	}

	public void setProfesionOficio(ProfesionOficio profesionOficio) {
		this.profesionOficio = profesionOficio;
	}

	public Empleado getJefe() {
		return jefe;
	}

	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}

	public Set<Empleado> getSubordinado() {
		return subordinado;
	}

	public void setSubordinado(Set<Empleado> subordinado) {
		this.subordinado = subordinado;
	}

	@Override
	public String toString() {
		return primer_nombre+" "+segundo_nombre+" "+primer_apellido+" "+segundo_apellido;
	}













}
