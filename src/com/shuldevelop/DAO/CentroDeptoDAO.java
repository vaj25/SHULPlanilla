package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.CentroDepto;
import com.shuldevelop.model.CentroDeptoPK;

public interface CentroDeptoDAO {

	public void add(CentroDepto centroDepto);
	
	public void edit(CentroDepto centroDepto);

	public void delete(CentroDeptoPK id_centro_depto);

	public CentroDepto getCentroDepto(CentroDeptoPK id_centro_depto);
	
	public List<CentroDepto> getAllCentroDepto();
	
}
