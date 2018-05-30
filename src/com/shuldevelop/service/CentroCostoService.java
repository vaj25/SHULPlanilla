package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.CentroCosto;

public interface CentroCostoService {

	public void add(CentroCosto centroCosto);
	
	public void edit(CentroCosto centroCosto);

	public void delete(int id_centro_costo);

	public CentroCosto getCentroCosto(int id_centro_costo);
	
	public List<CentroCosto> getAllCentroCosto();
	
}
