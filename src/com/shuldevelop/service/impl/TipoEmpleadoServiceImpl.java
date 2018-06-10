package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.TipoEmpleadoDAO;
import com.shuldevelop.model.TipoEmpleado;
import com.shuldevelop.service.TipoEmpleadoService;

@Service
public class TipoEmpleadoServiceImpl implements TipoEmpleadoService{
	
	@Autowired
	public TipoEmpleadoDAO tipoEmpleadoDAO;
	
	@Transactional
	public void add(TipoEmpleado tipoEmpleado) {
		
		tipoEmpleadoDAO.add(tipoEmpleado);
		
	}

	@Transactional
	public void edit(TipoEmpleado tipoEmpleado) {
		tipoEmpleadoDAO.edit(tipoEmpleado);

	}

	@Transactional
	public void delete(int idTipoEmpleado) {
		tipoEmpleadoDAO.delete(idTipoEmpleado);

	}

	@Transactional
	public TipoEmpleado getTipoEmpleado(int idTipoEmpleado) {
		return tipoEmpleadoDAO.getTipoEmpleado(idTipoEmpleado);
	}

	@Transactional
	public List<TipoEmpleado> getAllTipoEmpleado() {
		return tipoEmpleadoDAO.getAllTipoEmpleado();

	}
}
