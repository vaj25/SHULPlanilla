package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.TipoEmpleado;

public interface TipoEmpleadoService {
	
	public void add(TipoEmpleado tipoEmpleado);
	
	public void edit(TipoEmpleado tipoEmpleado);

	public void delete(int idTipoEmpleado);

	public TipoEmpleado getTipoEmpleado(int idTipoEmpleado);
	
	public List<TipoEmpleado> getAllTipoEmpleado();
}
