package com.shuldevelop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuldevelop.DAO.EmpleadoDAO;
import com.shuldevelop.model.Empleado;
import com.shuldevelop.service.EmpleadoService;
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	private EmpleadoDAO empleadoDAO;
	@Transactional
	public void add(Empleado empleado) {
		empleadoDAO.add(empleado);
	}

	@Transactional
	public void edit(Empleado empleado) {
		empleadoDAO.edit(empleado);

	}

	@Transactional
	public void delete(int idEmpleado) {
		empleadoDAO.delete(idEmpleado);

	}

	@Transactional
	public Empleado getEmpleado(int idEmpleado) {
		return empleadoDAO.getEmpleado(idEmpleado);
	}

	@Transactional
	public List<Empleado> getAllEmpleado() {
		return empleadoDAO.getAllEmpleado();
	}
	
	@Transactional
	public List<Empleado> getAllSub(int idEmpleado){
		return empleadoDAO.getAllSub(idEmpleado);
	}

}
