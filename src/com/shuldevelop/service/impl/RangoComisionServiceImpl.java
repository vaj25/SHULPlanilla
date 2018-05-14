package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RangoComisionDAO;
import com.shuldevelop.model.RangoComision;
import com.shuldevelop.service.RangoComisionService;

@Service
public class RangoComisionServiceImpl implements RangoComisionService {

	@Autowired
	RangoComisionDAO rangoComisionDAO;

	@Transactional
	public void add(RangoComision rangoComision) {

		rangoComisionDAO.add(rangoComision);

	}

	@Transactional
	public void edit(RangoComision rangoComision) {

		rangoComisionDAO.edit(rangoComision);

	}

	@Transactional
	public void delete(int idRangoComision) {

		rangoComisionDAO.delete(idRangoComision);

	}

	@Transactional
	public RangoComision getRangoComision(int idRangoComision) {

		return rangoComisionDAO.getRangoComision(idRangoComision);

	}

	@Transactional
	public List<RangoComision> getAllRangoComision() {

		return rangoComisionDAO.getAllRangoComision();

	}

}
