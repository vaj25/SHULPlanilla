package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.TipoEmpleado;

public interface TipoEmpleadoDAO {
	
	public void add(TipoEmpleado tipoEmpleado);
	
	public void edit(TipoEmpleado tipoEmpleado);

	public void delete(int idTipoEmpleado);

	public TipoEmpleado getTipoEmpleado(int idTipoEmpleado);
	
	public List<TipoEmpleado> getAllTipoEmpleado();
}
