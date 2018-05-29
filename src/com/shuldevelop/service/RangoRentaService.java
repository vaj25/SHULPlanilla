package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.RangoRenta;

public interface RangoRentaService {

	public void add(RangoRenta rangoRenta);

	public void edit(RangoRenta rangoRenta);
	
	public void up(RangoRenta rangoRenta);

	public void delete(int idRangoRenta);

	public RangoRenta getRangoRenta(int idRangoRenta);

	public List<RangoRenta> getAllRangoRenta();

}
