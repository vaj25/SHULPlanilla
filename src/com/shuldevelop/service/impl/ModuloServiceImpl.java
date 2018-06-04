package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.ModuloDAO;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.service.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService {

	@Autowired
	private ModuloDAO moduloDAO;
	
	@Transactional
	public void add(Modulo modulo) {

		moduloDAO.add(modulo);

	}

	@Transactional
	public void edit(Modulo modulo) {

		moduloDAO.edit(modulo);

	}

	@Transactional
	public void delete(int idModulo) {
		
		moduloDAO.delete(idModulo);

	}
	
	@Transactional
	public boolean hasModuloRolPermiso(int idModulo) {
		
		return moduloDAO.hasModuloRolPermiso(idModulo);
		
	}

	@Transactional
	public Modulo getModulo(int idModulo) {

		return moduloDAO.getModulo(idModulo);
		
	}

	@Transactional
	public List<Modulo> getAllModulo() {
		
		return moduloDAO.getAllModulo();
		
	}

	@Transactional
	public List<Modulo> getAllModuloParent() {

		return moduloDAO.getAllModuloParent();
		
	}
	
	@Transactional
	public List<Modulo> getAllModuloByRol(int idRol) {
		
		return moduloDAO.getAllModuloByRol(idRol);
		
	}

}
