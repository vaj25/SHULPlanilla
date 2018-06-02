package com.shuldevelop.service;

import com.shuldevelop.model.Permiso;

public interface PermisoService {

	public void add(Permiso permiso);
	
	public void edit(Permiso permiso);
	
	public void delete(int idPermiso);
	
	public Permiso getPermiso(int idPermiso);

}
