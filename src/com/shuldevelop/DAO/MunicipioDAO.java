package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Municipio;

public interface MunicipioDAO {

	public Municipio getMunicipio(int idMunicipio);
	
	public List<Municipio> getAllMunicipio();
	
	public List<Municipio> findMunicipioByDepartamento(int idDepartamento);
	
}
