package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.CentroCostoDAO;
import com.shuldevelop.model.CentroCosto;
import com.shuldevelop.service.CentroCostoService;

@Service
public class CentroCostoServiceImpl implements CentroCostoService {

	@Autowired
	public CentroCostoDAO centroCostoDAO;
	
	@Transactional
	public void add(CentroCosto centroCosto) {

		centroCostoDAO.add(centroCosto);
		
	}

	@Transactional
	public void edit(CentroCosto centroCosto) {
		centroCostoDAO.edit(centroCosto);


	}

	@Transactional
	public void delete(int id_centro_costo) {
		
		centroCostoDAO.delete(id_centro_costo);

	}

	@Transactional
	public CentroCosto getCentroCosto(int id_centro_costo) {
		return centroCostoDAO.getCentroCosto(id_centro_costo);

	}

	@Transactional
	public List<CentroCosto> getAllCentroCosto() {
		return centroCostoDAO.getAllCentroCosto();

	}

}
