package com.shuldevelop.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.PermisoDAO;
import com.shuldevelop.model.Permiso;
import com.shuldevelop.service.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService {

	@Autowired
	private PermisoDAO permisoDAO;	

	@Transactional
	public Permiso getPermiso(int idPermiso) {

		return permisoDAO.getPermiso(idPermiso);
		
	}

}
