package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.DireccionDAO;
import com.shuldevelop.model.Direccion;
import com.shuldevelop.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService {

	@Autowired
	public DireccionDAO direccionDAO;
	
	@Transactional
	public void add(Direccion direccion) {
		
		direccionDAO.add(direccion);

	}

	@Transactional
	public void edit(Direccion direccion) {

		direccionDAO.edit(direccion);
		
	}

	@Transactional
	public void delete(int idDirreccion) {
		
		direccionDAO.delete(idDirreccion);

	}

	@Transactional
	public Direccion getDireccion(int idDireccion) {
		
		return direccionDAO.getDireccion(idDireccion);
		
	}

	@Transactional
	public List<Direccion> getAllDireccion() {
		
		return direccionDAO.getAllDireccion();
		
	}

}
