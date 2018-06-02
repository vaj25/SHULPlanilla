package com.shuldevelop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RolModuloPermisoDAO;
import com.shuldevelop.model.RolModuloPermiso;
import com.shuldevelop.service.RolModuloPermisoService;

@Service
public class RolModuloPermisoServiceImpl implements RolModuloPermisoService {
	
	@Autowired
	private RolModuloPermisoDAO rolModuloPermisoDAO;

	@Override
	public void add(RolModuloPermiso rolModuloPermiso) {
		
		rolModuloPermisoDAO.add(rolModuloPermiso);

	}

	@Override
	public void edit(RolModuloPermiso rolModuloPermiso) {
		
		rolModuloPermisoDAO.edit(rolModuloPermiso);

	}

	@Override
	public void delete(int idRolModuloPermiso) {
		
		rolModuloPermisoDAO.delete(idRolModuloPermiso);

	}

	@Override
	public RolModuloPermiso getRolModuloPermiso(int idRolModuloPermiso) {

		return rolModuloPermisoDAO.getRolModuloPermiso(idRolModuloPermiso);
		
	}

	@Override
	public List<RolModuloPermiso> getAllRolModuloPermisoByRol(int idRol) {
		
		return rolModuloPermisoDAO.getAllRolModuloPermisoByRol(idRol);
		
	}

}
