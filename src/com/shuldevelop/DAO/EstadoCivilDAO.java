package com.shuldevelop.DAO;

import java.util.List;
import com.shuldevelop.model.EstadoCivil;

public interface EstadoCivilDAO {
	
	public void add(EstadoCivil estadoCivil);
	
	public void edit(EstadoCivil estadoCivil);
	
	public void delete(int idEstadoCivil);
	
	public EstadoCivil getEstadoCivil(int idEstadoCivil);
	
	public List<EstadoCivil> getAllEstadoCivil();
	
}
