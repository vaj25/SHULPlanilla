package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RolModuloPermisoDAO;
import com.shuldevelop.model.RolModuloPermiso;
import com.shuldevelop.service.RolModuloPermisoService;

@Service
public class RolModuloPermisoServiceImpl implements RolModuloPermisoService {
	
	@Autowired
	private RolModuloPermisoDAO rolModuloPermisoDAO;

	@Transactional
	public void add(RolModuloPermiso rolModuloPermiso) {
		
		rolModuloPermisoDAO.add(rolModuloPermiso);

	}

	@Transactional
	public void edit(RolModuloPermiso rolModuloPermiso) {
		
		rolModuloPermisoDAO.edit(rolModuloPermiso);

	}

	@Transactional
	public void delete(int idRolModuloPermiso) {
		
		rolModuloPermisoDAO.delete(idRolModuloPermiso);

	}

	@Transactional
	public RolModuloPermiso getRolModuloPermiso(int idRolModuloPermiso) {

		return rolModuloPermisoDAO.getRolModuloPermiso(idRolModuloPermiso);
		
	}

	@Transactional
	public List<RolModuloPermiso> getAllRolModuloPermisoByRol(int idRol) {
		
		return rolModuloPermisoDAO.getAllRolModuloPermisoByRol(idRol);
		
	}

}
