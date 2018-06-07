package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Usuario;

public interface UsuarioService {

	public Usuario findUserByUsername (String username);
	
	public void add(Usuario usuario);
	
	public void edit(Usuario usuario);
	
	public void delete(int idUsuario);
	
	public Usuario getUsuario(int idUsuario);
	
	public Usuario getUsuarioAdmin();
	
	public List<Usuario> getAllUsuario();
	
}
