package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.BitacoraLogin;

public interface BitacoraLoginDAO {
	
	public void add(BitacoraLogin bitacoraLogin);
	
	public List<BitacoraLogin> getAllBitacoraLogin();

}
