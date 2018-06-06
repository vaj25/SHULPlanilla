package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.BitacoraLoginDAO;
import com.shuldevelop.model.BitacoraLogin;
import com.shuldevelop.service.BitacoraLoginService;

@Service
public class BitacoraLoginServiceImpl implements BitacoraLoginService {

	@Autowired
	public BitacoraLoginDAO bitacoraLoginDAO;
	
	@Transactional
	public void add(BitacoraLogin bitacoraLogin) {
		
		bitacoraLoginDAO.add(bitacoraLogin);

	}

	@Transactional
	public List<BitacoraLogin> getAllBitacoraLogin() {
		
		return bitacoraLoginDAO.getAllBitacoraLogin();
		
	}

}
