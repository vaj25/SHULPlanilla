package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.BitacoraLoginDAO;
import com.shuldevelop.model.BitacoraLogin;

@Service
public class BitacoraLoginDAOImpl implements BitacoraLoginDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(BitacoraLogin bitacoraLogin) {
		
		session.getCurrentSession().saveOrUpdate(bitacoraLogin);

	}

	@Override
	public List<BitacoraLogin> getAllBitacoraLogin() {
		// TODO Auto-generated method stub
		return null;
	}

}
