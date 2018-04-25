package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.DepartamentoDAO;
import com.shuldevelop.model.Departamento;
import com.shuldevelop.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	@Transactional
	public Departamento getDepartamento(int idDepartamento) {
		
		return departamentoDAO.getDepartamento(idDepartamento);
	}

	@Transactional
	public List<Departamento> getAllDepartamento() {
		
		return departamentoDAO.getAllDepartamento();
	}

	@Transactional
	public List<Departamento> findDepartamentoByZona(int idZona) {
		
		return departamentoDAO.findDepartamentoByZona(idZona);
	}

}
