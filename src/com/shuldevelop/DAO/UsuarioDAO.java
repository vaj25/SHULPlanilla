package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Usuario;

public interface UsuarioDAO {
	
	public void add(Usuario usuario);
	
	public void edit(Usuario usuario);
	
	public void delete(int idUsuario);
	
	public Usuario getUsuario(int idUsuario);
	
	public Usuario getUsuarioAdmin();
	
	public List<Usuario> getAllUsuario();
	
	public Usuario findUserByUsername (String username);

}
