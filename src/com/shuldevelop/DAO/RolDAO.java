package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Rol;

public interface RolDAO {
	
	public Rol getRol(int idRol);
	
	public List<Rol> getAllRol();

}
