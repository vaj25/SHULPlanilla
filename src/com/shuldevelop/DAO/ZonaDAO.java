package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Zona;

public interface ZonaDAO {
	
	public Zona getZona(int idZona);
	
	public List<Zona> getAllZona();
	public void add(Zona zona);
	public void edit(Zona idZona);
	public void delete(int idZona);
}
