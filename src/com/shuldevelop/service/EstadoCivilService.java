package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.EstadoCivil;

public interface EstadoCivilService {

	public void add(EstadoCivil estadoCivil);
	
	public void edit(EstadoCivil estadoCivil);
	
	public void delete(int idEstadoCivil);
	
	public EstadoCivil getEstadoCivil(int idEstadoCivil);
	
	public List<EstadoCivil> getAllEstadoCivil();
	
}
