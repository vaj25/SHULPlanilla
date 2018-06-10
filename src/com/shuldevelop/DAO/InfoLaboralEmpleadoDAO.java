package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.InfoLaboralEmpleado;

public interface InfoLaboralEmpleadoDAO {
	public void add(InfoLaboralEmpleado infoLaboralEmpleado);
	
	public void edit(InfoLaboralEmpleado infoLaboralEmpleado);

	public void delete(int idInfoLaboralEmpleado);

	public InfoLaboralEmpleado getInfoLaboralEmpleado(int idInfoLaboralEmpleado);
	
	public List<InfoLaboralEmpleado> getAllInfoLaboralEmpleado();
}
