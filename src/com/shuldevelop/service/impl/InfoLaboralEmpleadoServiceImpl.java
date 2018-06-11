package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.InfoLaboralEmpleadoDAO;
import com.shuldevelop.model.InfoLaboralEmpleado;
import com.shuldevelop.service.InfoLaboralEmpleadoService;

@Service
public class InfoLaboralEmpleadoServiceImpl implements InfoLaboralEmpleadoService{

	
	@Autowired
	public InfoLaboralEmpleadoDAO InfoLaboralEmpleadoDAO;
	
	@Transactional
	public void add(InfoLaboralEmpleado infoLaboralEmpleado) {

		InfoLaboralEmpleadoDAO.add(infoLaboralEmpleado);
		
	}

	@Transactional
	public void edit(InfoLaboralEmpleado infoLaboralEmpleado) {
		InfoLaboralEmpleadoDAO.edit(infoLaboralEmpleado);


	}

	@Transactional
	public void delete(int id_info_laboral_empleado) {
		
		InfoLaboralEmpleadoDAO.delete(id_info_laboral_empleado);

	}

	@Transactional
	public InfoLaboralEmpleado getInfoLaboralEmpleado(int id_info_laboral_empleado) {
		return InfoLaboralEmpleadoDAO.getInfoLaboralEmpleado(id_info_laboral_empleado);

	}

	@Transactional
	public List<InfoLaboralEmpleado> getAllInfoLaboralEmpleado() {
		return InfoLaboralEmpleadoDAO.getAllInfoLaboralEmpleado();

	}
		
	@Transactional
	public InfoLaboralEmpleado getInfobyIdEmpleado(int idEmpleado) {
		return InfoLaboralEmpleadoDAO.getInfobyIdEmpleado(idEmpleado);

	}
}
