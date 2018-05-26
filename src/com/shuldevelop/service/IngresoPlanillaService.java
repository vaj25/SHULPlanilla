package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.IngresoPlanilla;
import com.shuldevelop.model.IngresoPlanillaId;

public interface IngresoPlanillaService {

	public void add(IngresoPlanilla ingresoPlanilla);
	
	public void edit(IngresoPlanilla ingresoPlanilla);
	
	public void delete(IngresoPlanillaId idIngresoPlanilla);
	
	public IngresoPlanilla getIngresoPlanilla(IngresoPlanillaId idIngresoPlanilla);
	
	public List<IngresoPlanilla> getAllIngresoPlanilla();
	
	public List<IngresoPlanilla> getAllIngresoPlanillaByPlanilla(int idEmpleadoPlanilla);
	
}
