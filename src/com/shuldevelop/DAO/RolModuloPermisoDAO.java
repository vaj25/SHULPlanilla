package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.RolModuloPermiso;

public interface RolModuloPermisoDAO {
	
	public void add(RolModuloPermiso rolModuloPermiso);
	
	public void edit(RolModuloPermiso rolModuloPermiso);
	
	public void delete(int idRolModuloPermiso);
	
	public RolModuloPermiso getRolModuloPermiso(int idRolModuloPermiso);
	
	public List<RolModuloPermiso> getAllRolModuloPermisoByRol(int idRol);

}
