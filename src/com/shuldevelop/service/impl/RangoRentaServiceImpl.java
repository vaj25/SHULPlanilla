package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.model.RangoRenta;
import com.shuldevelop.DAO.RangoRentaDAO;
import com.shuldevelop.service.RangoRentaService;

@Service
public class RangoRentaServiceImpl implements RangoRentaService {

	@Autowired
	public RangoRentaDAO rangoRentaDAO;

	@Transactional
	public void add(RangoRenta rangoRenta) {

		rangoRentaDAO.add(rangoRenta);

	}
	
	@Transactional
	public void up(RangoRenta rangoRenta) {

		rangoRentaDAO.up(rangoRenta);

	}

	@Transactional
	public void edit(RangoRenta rangoRenta) {

		rangoRentaDAO.edit(rangoRenta);

	}

	@Transactional
	public void delete(int idRangoRenta) {

		rangoRentaDAO.delete(idRangoRenta);

	}

	@Transactional
	public RangoRenta getRangoRenta(int idRangoRenta) {

		return rangoRentaDAO.getRangoRenta(idRangoRenta);

	}

	@Transactional
	public List<RangoRenta> getAllRangoRenta() {

		return rangoRentaDAO.getAllRangoRenta();

	}

}
