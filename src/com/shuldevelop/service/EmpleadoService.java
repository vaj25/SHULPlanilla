package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Empleado;

public interface EmpleadoService {
	public void add(Empleado empleado);
	public void edit(Empleado empleado);
	public void delete(int idEmpleado);
	public Empleado getEmpleado(int idEmpleado);
	public List<Empleado> getAllEmpleado();
	public List<Empleado> getAllSub(int idEmpleado);
}