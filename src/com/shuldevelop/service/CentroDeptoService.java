package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.CentroDepto;
import com.shuldevelop.model.CentroDeptoPK;

public interface CentroDeptoService {
	public void add(CentroDepto centroDepto);
	
	public void edit(CentroDepto centroDepto);

	public void delete(CentroDeptoPK id_centro_depto);

	public CentroDepto getCentroDepto(CentroDeptoPK id);
	
	public List<CentroDepto> getAllCentroDepto();
}
	