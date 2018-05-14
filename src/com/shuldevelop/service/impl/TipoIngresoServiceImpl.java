package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.TipoIngresoDAO;
import com.shuldevelop.model.TipoIngreso;
import com.shuldevelop.service.TipoIngresoService;

@Service
public class TipoIngresoServiceImpl implements TipoIngresoService {

	@Autowired
	TipoIngresoDAO tipoIngresoDAO;
	
	@Transactional
	public void add(TipoIngreso tipoIngreso) {
		
		tipoIngresoDAO.add(tipoIngreso);

	}

	@Transactional
	public void edit(TipoIngreso tipoIngreso) {
		
		tipoIngresoDAO.edit(tipoIngreso);

	}

	@Transactional
	public void delete(int idTipoIngreso) {
		
		tipoIngresoDAO.delete(idTipoIngreso);

	}

	@Transactional
	public TipoIngreso getTipoIngreso(int idTipoIngreso) {
		
		return tipoIngresoDAO.getTipoIngreso(idTipoIngreso);
		
	}

	@Transactional
	public List<TipoIngreso> getAllTipoIngreso() {
		
		return tipoIngresoDAO.getAllTipoIngreso();
		
	}

}
