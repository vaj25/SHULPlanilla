package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.ZonaDAO;
import com.shuldevelop.model.Zona;
import com.shuldevelop.service.ZonaService;

@Service
public class ZonaServiceImpl implements ZonaService {

	@Autowired
	private ZonaDAO zonaDOA;
	
	@Transactional
	public Zona getZona(int idZona) {
		
		return zonaDOA.getZona(idZona);
	}

	@Transactional
	public List<Zona> getAllZona() {

		return zonaDOA.getAllZona();
	}

}
