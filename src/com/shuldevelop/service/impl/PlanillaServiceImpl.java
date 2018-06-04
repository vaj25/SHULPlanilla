package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.model.Planilla;
import com.shuldevelop.DAO.PlanillaDAO;
import com.shuldevelop.service.PlanillaService;

@Service
public class PlanillaServiceImpl implements PlanillaService {

	@Autowired
	public PlanillaDAO planillaDAO;

	@Transactional
	public void add(Planilla planilla) {

		planillaDAO.add(planilla);

	}

	@Transactional
	public void edit(Planilla planilla) {

		planillaDAO.edit(planilla);

	}

	@Transactional
	public void updateDates(Planilla planilla) {

		planillaDAO.updateDates(planilla);

	}

	@Transactional
	public void delete(int idPlanilla) {

		planillaDAO.delete(idPlanilla);

	}

	@Transactional
	public Planilla getPlanilla(int idPlanilla) {

		return planillaDAO.getPlanilla(idPlanilla);

	}

	@Transactional
	public List<Planilla> getAllPlanilla() {

		return planillaDAO.getAllPlanilla();

	}

}
