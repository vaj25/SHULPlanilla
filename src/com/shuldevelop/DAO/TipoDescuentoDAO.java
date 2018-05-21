package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.TipoDescuento;

public interface TipoDescuentoDAO {

	public void add(TipoDescuento tipoDescuento);

	public void edit(TipoDescuento tipoDescuento);

	public void delete(int idTipoDescuento);

	public TipoDescuento getTipoDescuento(int idTipoDescuento);

	public List<TipoDescuento> getAllTipoDescuento();

}
