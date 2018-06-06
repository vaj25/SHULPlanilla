package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.BitacoraLogin;

public interface BitacoraLoginService {

	public void add(BitacoraLogin bitacoraLogin);
	
	public List<BitacoraLogin> getAllBitacoraLogin();
	
}
