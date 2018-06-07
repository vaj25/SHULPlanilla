package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.DescuentoPlanillaDAO;
import com.shuldevelop.model.DescuentoPlanilla;
import com.shuldevelop.model.DescuentoPlanillaId;
import com.shuldevelop.service.DescuentoPlanillaService;

@Service
public class DescuentoPlanillaServiceImpl implements DescuentoPlanillaService {

	@Autowired
	private DescuentoPlanillaDAO descuentoPlanillaDAO;

	@Transactional
	public void add(DescuentoPlanilla descuentoPlanilla) {

		descuentoPlanillaDAO.add(descuentoPlanilla);

	}

	@Transactional
	public void edit(DescuentoPlanilla descuentoPlanilla) {

		descuentoPlanillaDAO.edit(descuentoPlanilla);

	}

	@Transactional
	public void delete(DescuentoPlanillaId idDescuentoPlanilla) {

		descuentoPlanillaDAO.delete(idDescuentoPlanilla);

	}

	@Transactional
	public DescuentoPlanilla getDescuentoPlanilla(DescuentoPlanillaId idDescuentoPlanilla) {

		return descuentoPlanillaDAO.getDescuentoPlanilla(idDescuentoPlanilla);

	}

	@Transactional
	public List<DescuentoPlanilla> getAllDescuentoPlanilla() {

		return descuentoPlanillaDAO.getAllDescuentoPlanilla();

	}

	@Transactional
	public List<DescuentoPlanilla> getAllDescuentoPlanillaByPlanilla(int idEmpleadoPlanilla) {

		return descuentoPlanillaDAO.getAllDescuentoPlanillaByPlanilla(idEmpleadoPlanilla);

	}
}
