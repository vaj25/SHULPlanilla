package com.shuldevelop.service.impl;

import java.util.Hashtable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EmpleadoDAO;
import com.shuldevelop.model.Empleado;
import com.shuldevelop.model.EmpleadoView;
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
	
	@Transactional
	public List<Empleado> getDui(String dui){
		return empleadoDAO.getDui(dui);
	}
	
	@Transactional
	public List<Empleado> getNit(String Nnit){
		return empleadoDAO.getNit(Nnit);
	}
	
	@Transactional
	public List<Empleado> getIsss(int Nisss){
		return empleadoDAO.getIsss(Nisss);
	}
	
	@Transactional
	public List<Empleado> getNup(long Nnup){
		return empleadoDAO.getNup(Nnup);
	}
	
	@Transactional
	public List<Empleado> getEmpEmail(String emailEmp){
		return empleadoDAO.getEmpEmail(emailEmp);
	}
	
	@Transactional
	public List<Empleado> getInsEmail(String emailInst){
		return empleadoDAO.getInsEmail(emailInst);
	}

	@Transactional
	public List<Empleado> getOneEmpleado(int idEmpleado) {
		return empleadoDAO.getOneEmpleado(idEmpleado);
	}
	
	@Transactional
	public List<EmpleadoView> getViewEmpleado(Hashtable<String, String> listParameter) {
		
		return empleadoDAO.getViewEmpleado(listParameter);
		
	}
	
}
