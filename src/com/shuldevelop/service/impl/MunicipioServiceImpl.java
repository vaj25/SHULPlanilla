package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.MunicipioDAO;
import com.shuldevelop.model.Municipio;
import com.shuldevelop.service.MunicipioService;

@Service
public class MunicipioServiceImpl implements MunicipioService {

	@Autowired
	private MunicipioDAO municipioDAO;
	
	@Transactional
	public Municipio getMunicipio(int idMunicipio) {
		
		return municipioDAO.getMunicipio(idMunicipio);
	}

	@Transactional
	public List<Municipio> getAllMunicipio() {
		
		return municipioDAO.getAllMunicipio();
	}

	@Transactional
	public List<Municipio> findMunicipioByDepartamento(int idDepartamento) {
		
		return municipioDAO.findMunicipioByDepartamento(idDepartamento);
	}

}
