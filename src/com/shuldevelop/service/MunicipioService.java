package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Municipio;

public interface MunicipioService {
	
	public Municipio getMunicipio(int idMunicipio);
	
	public List<Municipio> getAllMunicipio();
	
	public List<Municipio> findMunicipioByDepartamento(int idDepartamento);
	public void add(Municipio municipio);
	public void edit(Municipio municipio);
	public void delete(int idMunicipio);

}
