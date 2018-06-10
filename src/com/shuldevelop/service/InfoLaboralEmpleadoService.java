package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.InfoLaboralEmpleado;

public interface InfoLaboralEmpleadoService {
	
	public void add(InfoLaboralEmpleado infoLaboralEmpleado);
	
	public void edit(InfoLaboralEmpleado infoLaboralEmpleado);

	public void delete(int id_info_laboral_empleado);

	public InfoLaboralEmpleado getInfoLaboralEmpleado(int id_info_laboral_empleado);
	
	public List<InfoLaboralEmpleado> getAllInfoLaboralEmpleado();
}
