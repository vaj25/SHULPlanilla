package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.RangoComision;

public interface RangoComisionService {

	public void add(RangoComision rangoComision);
	
	public void edit(RangoComision rangoComision);
	
	public void delete(int idRangoComision);
	
	public RangoComision getRangoComision(int idRangoComision);
	
	public RangoComision getRangoComisionByVenta(double venta);
	
	public List<RangoComision> getAllRangoComision();
	
}
