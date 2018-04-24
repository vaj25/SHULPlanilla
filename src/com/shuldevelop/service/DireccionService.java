package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Direccion;

public interface DireccionService {

	public void add(Direccion direccion);
	
	public void edit(Direccion direccion);
	
	public void delete(int idDirreccion);
	
	public Direccion getDireccion(int idDireccion);
	
	public List<Direccion> getAllDireccion();
	
}
