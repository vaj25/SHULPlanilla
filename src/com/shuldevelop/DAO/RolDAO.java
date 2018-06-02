package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Rol;

public interface RolDAO {
	
	public void add(Rol rol);
	
	public void edit(Rol rol);
	
	public void delete(int idRol);
	
	public Rol getRol(int idRol);
	
	public List<Rol> getAllRol();

}
