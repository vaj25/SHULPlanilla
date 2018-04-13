package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.TipoDocIdentidad;

public interface TipoDocIdentidadDAO {
	
	public void add(TipoDocIdentidad tipoDocIdentidad);
	
	public void edit(TipoDocIdentidad tipoDocIdentidad);
	
	public void delete(int idTipoDocIdentidad);
	
	public TipoDocIdentidad getTipoDocIdentidad(int idTipoDocIdentidad);
	
	public List<TipoDocIdentidad> getAllTipoDocIdentidad();
	
}
