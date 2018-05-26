package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.RangoPlanilla;
import com.shuldevelop.model.RangoPlanillaId;

public interface RangoPlanillaService {

	public void add(RangoPlanilla rangoPlanilla);
	
	public void edit(RangoPlanilla rangoPlanilla);
	
	public void delete(RangoPlanillaId idRangoPlanilla);
	
	public RangoPlanilla getRangoPlanilla(RangoPlanillaId idRangoPlanilla);
	
	public List<RangoPlanilla> getAllRangoPlanilla();
	
	public RangoPlanilla getRangoPlanillaByPlanilla(int idPlanillaEmpleado);
}
