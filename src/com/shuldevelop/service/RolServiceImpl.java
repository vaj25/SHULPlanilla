package com.shuldevelop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RolDAO;
import com.shuldevelop.model.Rol;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
    private RolDAO rolDao;
	
	@Override
	public Rol getRol(int idRol) {
		
		return rolDao.getRol(idRol);
		
	}

	@Override
	public List<Rol> getAllRol() {
		
		return rolDao.getAllRol();
		
	}

}
