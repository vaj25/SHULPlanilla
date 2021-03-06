package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Modulo;

public interface ModuloDAO {

	public void add(Modulo modulo);
	
	public void edit(Modulo modulo);
	
	public void delete(int idModulo);
	
	public boolean hasModuloRolPermiso(int idModulo);
	
	public Modulo getModulo(int idModulo);
	
	public List<Modulo> getAllModulo();
	
	public List<Modulo> getAllModuloParent();
	
	public List<Modulo> getAllModuloByRol(int idRol);
	
}
