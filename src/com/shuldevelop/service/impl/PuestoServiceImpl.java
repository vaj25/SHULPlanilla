package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.PuestoDAO;
import com.shuldevelop.model.Puesto;
import com.shuldevelop.service.PuestoService;

@Service
public class PuestoServiceImpl implements PuestoService {
	
	@Autowired
	PuestoDAO puestoDAO;

	@Transactional
	public void add(Puesto puesto) {
		
		puestoDAO.add(puesto);

	}

	@Transactional
	public void edit(Puesto puesto) {
		
		puestoDAO.edit(puesto);

	}

	@Transactional
	public void delete(int idPuesto) {
		
		puestoDAO.delete(idPuesto);

	}
	
	@Transactional
	public boolean hasPuestoEmpleado(int idPuesto) {
		
		return puestoDAO.hasPuestoEmpleado(idPuesto);
		
	}

	@Transactional
	public Puesto getPuesto(int idPuesto) {
		
		return puestoDAO.getPuesto(idPuesto);
		
	}

	@Transactional
	public List<Puesto> getAllPuesto() {

		return puestoDAO.getAllPuesto();
		
	}

}
