package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.NivelPuesto;

public interface NivelPuestoService {

	public void add(NivelPuesto tipoPuesto);
	
	public void edit(NivelPuesto tipoPuesto);
	
	public void delete(int idTipoPuesto);
	
	public NivelPuesto getTipoPuesto(int idTipoPuesto);
	
	public List<NivelPuesto> getAllTipoPuesto();
	
}
