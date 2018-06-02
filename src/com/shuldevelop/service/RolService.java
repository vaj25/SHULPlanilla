package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Rol;

public interface RolService {
	
	public void add(Rol rol);
	
	public void edit(Rol rol);
	
	public void delete(int idRol);

	public Rol getRol(int idRol);
	
	public List<Rol> getAllRol();
	
}
