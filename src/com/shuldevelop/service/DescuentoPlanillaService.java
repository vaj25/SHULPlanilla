package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.DescuentoPlanilla;
import com.shuldevelop.model.DescuentoPlanillaId;

public interface DescuentoPlanillaService {

	public void add(DescuentoPlanilla descuentoPlanilla);

	public void edit(DescuentoPlanilla descuentoPlanilla);

	public void delete(DescuentoPlanillaId idDescuentoPlanilla);

	public DescuentoPlanilla getDescuentoPlanilla(DescuentoPlanillaId idDescuentoPlanilla);

	public List<DescuentoPlanilla> getAllDescuentoPlanilla();

	public List<DescuentoPlanilla> getAllDescuentoPlanillaByPlanilla(int idEmpleadoPlanilla);

}
