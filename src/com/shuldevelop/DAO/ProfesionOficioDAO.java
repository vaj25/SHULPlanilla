package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.ProfesionOficio;

public interface ProfesionOficioDAO {
	
	public void add(ProfesionOficio profesionOficio);
	public void edit(ProfesionOficio profesionOficio);
	public void delete(int idProfesionOficio);
	public ProfesionOficio getProfesionOficio(int idProfesionOficio);
	public List<ProfesionOficio> getAllProfesionOficio();

}
