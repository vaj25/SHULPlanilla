package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Puesto;

public interface PuestoDAO {
	
	public void add(Puesto puesto);
	
	public void edit(Puesto puesto);
	
	public void delete(int idPuesto);
	
	public Puesto getPuesto(int idPuesto);
	
	public List<Puesto> getAllPuesto();

}
