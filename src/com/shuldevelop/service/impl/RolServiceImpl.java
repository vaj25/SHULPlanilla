package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RolDAO;
import com.shuldevelop.model.Rol;
import com.shuldevelop.service.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
    private RolDAO rolDao;
	
	@Transactional
	public Rol getRol(int idRol) {
		
		return rolDao.getRol(idRol);
		
	}

	@Transactional
	public List<Rol> getAllRol() {
		
		return rolDao.getAllRol();
		
	}

}
