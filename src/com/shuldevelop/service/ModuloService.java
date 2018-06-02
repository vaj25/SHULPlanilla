package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Modulo;

public interface ModuloService {

	public void add(Modulo modulo);
	
	public void edit(Modulo modulo);
	
	public void delete(int idModulo);
	
	public Modulo getModulo(int idModulo);
	
	public List<Modulo> getAllModulo();
	
	public List<Modulo> getAllModuloByRol(int idRol);
	
}
