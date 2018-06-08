package com.shuldevelop.service;
import java.util.List;

import com.shuldevelop.model.RolModuloPermiso;

public interface RolModuloPermisoService {

	public void add(RolModuloPermiso rolModuloPermiso);
	
	public void edit(RolModuloPermiso rolModuloPermiso);
	
	public void delete(int idRolModuloPermiso);
	
	public int getCountRolModuloPermisoByRol(int idRol);
	
	public RolModuloPermiso getRolModuloPermiso(int idRolModuloPermiso);
	
	public List<RolModuloPermiso> getAllRolModuloPermisoByRol(int idRol, int page, int perPage);
	
}
