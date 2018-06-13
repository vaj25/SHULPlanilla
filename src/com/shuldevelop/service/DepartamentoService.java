package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Departamento;

public interface DepartamentoService {

	public Departamento getDepartamento(int idDepartamento);
	
	public List<Departamento> getAllDepartamento();
	
	public List<Departamento> findDepartamentoByZona(int idZona);
	public void add(Departamento departamento);
	public void edit(Departamento departamento);
	public void delete(int idDepartamento);
	
}
