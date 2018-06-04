package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RolDAO;
import com.shuldevelop.model.Rol;
import com.shuldevelop.service.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
    private RolDAO rolDao;
	
	@Transactional
	public void add(Rol rol) {
		
		rolDao.add(rol);
		
	}

	@Transactional
	public void edit(Rol rol) {

		rolDao.edit(rol);
		
	}

	@Transactional
	public void delete(int idRol) {
		
		rolDao.delete(idRol);
		
	}
	
	@Transactional
	public boolean hasRolModuloPermiso(int idRol) {
		
		return rolDao.hasRolModuloPermiso(idRol);
		
	}
	
	@Transactional
	public Rol getRol(int idRol) {
		
		return rolDao.getRol(idRol);
		
	}

	@Transactional
	public List<Rol> getAllRol() {
		
		return rolDao.getAllRol();
		
	}

}
