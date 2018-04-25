package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Departamento;

public interface DepartamentoDAO {
	
	public Departamento getDepartamento(int idDepartamento);
	
	public List<Departamento> getAllDepartamento();
	
	public List<Departamento> findDepartamentoByZona(int idZona);
	
}
