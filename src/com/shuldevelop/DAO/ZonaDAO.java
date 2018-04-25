package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Zona;

public interface ZonaDAO {
	
	public Zona getZona(int idZona);
	
	public List<Zona> getAllZona();

}
