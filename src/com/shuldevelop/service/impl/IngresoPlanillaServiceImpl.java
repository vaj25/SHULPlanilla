package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.IngresoPlanillaDAO;
import com.shuldevelop.model.IngresoPlanilla;
import com.shuldevelop.model.IngresoPlanillaId;
import com.shuldevelop.service.IngresoPlanillaService;

@Service
public class IngresoPlanillaServiceImpl implements IngresoPlanillaService {

	@Autowired
	private IngresoPlanillaDAO ingresoPlanillaDAO;
	
	@Transactional
	public void add(IngresoPlanilla ingresoPlanilla) {
		
		ingresoPlanillaDAO.add(ingresoPlanilla);

	}

	@Transactional
	public void edit(IngresoPlanilla ingresoPlanilla) {
		
		ingresoPlanillaDAO.edit(ingresoPlanilla);

	}

	@Transactional
	public void delete(IngresoPlanillaId idIngresoPlanilla) {
		
		ingresoPlanillaDAO.delete(idIngresoPlanilla);

	}

	@Transactional
	public IngresoPlanilla getIngresoPlanilla(IngresoPlanillaId idIngresoPlanilla) {
		
		return ingresoPlanillaDAO.getIngresoPlanilla(idIngresoPlanilla);
		
	}

	@Transactional
	public List<IngresoPlanilla> getAllIngresoPlanilla() {

		return ingresoPlanillaDAO.getAllIngresoPlanilla();
		
	}

}
