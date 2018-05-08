package com.shuldevelop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuldevelop.DAO.ProfesionOficioDAO;
import com.shuldevelop.model.ProfesionOficio;
import com.shuldevelop.service.ProfesionOficioService;
@Service
public class ProfesionOficioServiceImpl implements ProfesionOficioService {
	@Autowired
	private ProfesionOficioDAO profesionDAO;
	
	@Transactional
	public void add(ProfesionOficio profesionOficio) {
		profesionDAO.add(profesionOficio);

	}

	@Transactional
	public void edit(ProfesionOficio profesionOficio) {
		profesionDAO.edit(profesionOficio);

	}

	@Transactional
	public void delete(int idProfesionOficio) {
		profesionDAO.delete(idProfesionOficio);

	}

	@Transactional
	public ProfesionOficio getProfesionOficio(int idProfesionOficio) {
		return profesionDAO.getProfesionOficio(idProfesionOficio);
	}

	@Transactional
	public List<ProfesionOficio> getAllProfesionOficio() {
		return profesionDAO.getAllProfesionOficio();
	}

}
