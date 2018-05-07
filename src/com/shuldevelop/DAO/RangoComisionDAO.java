package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.RangoComision;

public interface RangoComisionDAO {

	public void add(RangoComision rangoComision);
	
	public void edit(RangoComision rangoComision);
	
	public void delete(int idRangoComision);
	
	public RangoComision getRangoComision(int idRangoComision);
	
	public List<RangoComision> getAllRangoComision();
	
}
