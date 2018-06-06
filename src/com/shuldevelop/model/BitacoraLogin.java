package com.shuldevelop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "BITACORA_LOGIN")
@Table(name = "BITACORA_LOGIN")
public class BitacoraLogin {

	@Id
	@Column(name = "id_bitacora_login")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BITACORA_LOGIN")
	@SequenceGenerator(name = "SEQ_BITACORA_LOGIN", sequenceName = "SEQ_BITACORA_LOGIN", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name = "fecha_login")
	private Date fecha;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_login")
	private TipoLogin tipoLogin;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public BitacoraLogin() {
	}

	public BitacoraLogin(Date fecha, TipoLogin tipoLogin, Usuario usuario) {
		this.fecha = fecha;
		this.tipoLogin = tipoLogin;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TipoLogin getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(TipoLogin tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
}
