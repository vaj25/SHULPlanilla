package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.shuldevelop.DAO.RangoPlanillaDAO;
import com.shuldevelop.model.RangoPlanilla;
import com.shuldevelop.model.RangoPlanillaId;
import com.shuldevelop.service.RangoPlanillaService;

public class RangoPlanillaServiceImpl implements RangoPlanillaService {

	@Autowired
    private RangoPlanillaDAO rangoPlanillaDao;
	
	@Transactional
	public void add(RangoPlanilla rangoPlanilla) {
		
		rangoPlanillaDao.add(rangoPlanilla);
		
	}

	@Transactional
	public void edit(RangoPlanilla rangoPlanilla) {
		
		rangoPlanillaDao.edit(rangoPlanilla);

	}

	@Transactional
	public void delete(RangoPlanillaId idRangoPlanilla) {
		
		rangoPlanillaDao.deleteRangoPlanilla(idRangoPlanilla);

	}

	@Transactional
	public RangoPlanilla getRangoPlanilla(RangoPlanillaId idRangoPlanilla) {
		
		return rangoPlanillaDao.getRangoPlanilla(idRangoPlanilla);
		
	}

	@Transactional
	public List<RangoPlanilla> getAllRangoPlanilla() {
		
		return rangoPlanillaDao.getAllRangoPlanilla();
		
	}

}
