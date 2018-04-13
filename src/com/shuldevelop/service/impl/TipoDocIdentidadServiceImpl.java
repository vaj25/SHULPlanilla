package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.TipoDocIdentidadDAO;
import com.shuldevelop.model.TipoDocIdentidad;
import com.shuldevelop.service.TipoDocIdentidadService;

@Service
public class TipoDocIdentidadServiceImpl implements TipoDocIdentidadService {
	
	@Autowired
	public TipoDocIdentidadDAO tipoDocIdentidadDao;
	
	@Transactional
	public void add(TipoDocIdentidad tipoDocIdentidad) {

		tipoDocIdentidadDao.add(tipoDocIdentidad);
		
	}

	@Transactional
	public void edit(TipoDocIdentidad tipoDocIdentidad) {
		
		tipoDocIdentidadDao.edit(tipoDocIdentidad);
		
	}

	@Transactional
	public void delete(int idTipoDocIdentidad) {
		
		tipoDocIdentidadDao.delete(idTipoDocIdentidad);
		
	}

	@Transactional
	public TipoDocIdentidad getTipoDocIdentidad(int idTipoDocIdentidad) {
		
		return tipoDocIdentidadDao.getTipoDocIdentidad(idTipoDocIdentidad);
	}

	@Transactional
	public List<TipoDocIdentidad> getAllTipoDocIdentidad() {
		
		return tipoDocIdentidadDao.getAllTipoDocIdentidad();
	}

}
