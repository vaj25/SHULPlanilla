package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.ProfesionOficio;

public interface ProfesionOficioService {
	public void add(ProfesionOficio profesionOficio);
	public void edit(ProfesionOficio profesionOficio);
	public void delete(int idProfesionOficio);
	public ProfesionOficio getProfesionOficio(int idProfesionOficio);
	public List<ProfesionOficio> getAllProfesionOficio();
}
