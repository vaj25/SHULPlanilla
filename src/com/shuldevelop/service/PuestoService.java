package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Puesto;

public interface PuestoService {

	public void add(Puesto puesto);
	
	public void edit(Puesto puesto);
	
	public void delete(int idPuesto);
	
	public Puesto getPuesto(int idPuesto);
	
	public List<Puesto> getAllPuesto();
	
}
