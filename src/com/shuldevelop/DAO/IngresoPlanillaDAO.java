package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.IngresoPlanilla;
import com.shuldevelop.model.IngresoPlanillaId;

public interface IngresoPlanillaDAO {

	public void add(IngresoPlanilla ingresoPlanilla);
	
	public void edit(IngresoPlanilla ingresoPlanilla);
	
	public void delete(IngresoPlanillaId idIngresoPlanilla);
	
	public IngresoPlanilla getIngresoPlanilla(IngresoPlanillaId idIngresoPlanilla);
	
	public List<IngresoPlanilla> getAllIngresoPlanilla();
	
}
