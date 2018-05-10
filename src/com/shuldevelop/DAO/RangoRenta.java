package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.RangoRenta;

public interface RangoRentaDAO {

	public void add(RangoRenta rangoRenta);

	public void edit(RangoRenta rangoRenta);

	public void delete(int idRangoRenta);

	public RangoRenta getRangoRenta(int idRangoRenta);

	public List<RangoRenta> getAllRangoRenta();

}
