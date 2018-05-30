package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.CentroDeptoDAO;
import com.shuldevelop.model.CentroDepto;
import com.shuldevelop.model.CentroDeptoPK;
import com.shuldevelop.service.CentroDeptoService;

@Service
public class CentroDeptoServiceImpl implements CentroDeptoService{

	
	@Autowired
	public CentroDeptoDAO centroDeptoDAO;
	
	@Transactional
	public void add(CentroDepto centroDepto) {

		centroDeptoDAO.add(centroDepto);
		
	}

	@Transactional
	public void edit(CentroDepto centroDepto) {
		centroDeptoDAO.edit(centroDepto);


	}

	@Transactional
	public void delete(CentroDeptoPK id_centro_costo) {
		
		centroDeptoDAO.delete(id_centro_costo);

	}

	@Transactional
	public CentroDepto getCentroDepto(CentroDeptoPK id_centro_costo) {
		return centroDeptoDAO.getCentroDepto(id_centro_costo);

	}

	@Transactional
	public List<CentroDepto> getAllCentroDepto() {
		return centroDeptoDAO.getAllCentroDepto();

	}
	
	
}
