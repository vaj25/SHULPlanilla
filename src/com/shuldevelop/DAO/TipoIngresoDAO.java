package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.TipoIngreso;

public interface TipoIngresoDAO {
	
	public void add(TipoIngreso tipoIngreso);
	
	public void edit(TipoIngreso tipoIngreso);
	
	public void delete(int idTipoIngreso);
	
	public TipoIngreso getTipoIngreso(int idTipoIngreso);
	
	public List<TipoIngreso> getAllTipoIngreso();

}
