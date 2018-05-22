package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.EmpleadoPlanilla;

public interface EmpleadoPlanillaDAO {

	public void add(EmpleadoPlanilla empleadoPlanilla);
	
	public void edit(EmpleadoPlanilla empleadoPlanilla);
	
	public void delete(int idEmpleadoPlanilla);
	
	public EmpleadoPlanilla getEmpleadoPlanilla(int idEmpleadoPlanilla);
	
	public List<EmpleadoPlanilla> getAllEmpleadoPlanilla();
	
}
