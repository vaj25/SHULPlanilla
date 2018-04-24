package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EstadoCivilDAO;
import com.shuldevelop.model.EstadoCivil;
import com.shuldevelop.service.EstadoCivilService;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {
	
	@Autowired
	public EstadoCivilDAO estadoCivilDao;
	
	@Transactional
	public void add(EstadoCivil estadoCivil) {

		estadoCivilDao.add(estadoCivil);
		
	}

	@Transactional
	public void edit(EstadoCivil estadoCivil) {
		
		estadoCivilDao.edit(estadoCivil);
		
	}

	@Transactional
	public void delete(int idEstadoCivil) {
		
		estadoCivilDao.delete(idEstadoCivil);
		
	}

	@Transactional
	public EstadoCivil getEstadoCivil(int idEstadoCivil) {
		
		return estadoCivilDao.getEstadoCivil(idEstadoCivil);
	}

	@Transactional
	public List<EstadoCivil> getAllEstadoCIvil() {
		
		return estadoCivilDao.getAllEstadoCivil();
	}

	@Override
	public List<EstadoCivil> getAllEstadoCivil() {
		// TODO Auto-generated method stub
		return null;
	}

}
