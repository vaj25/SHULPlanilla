package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.TipoDescuento;

public interface TipoDescuentoService {

	public void add(TipoDescuento tipoDescuento);

	public void edit(TipoDescuento tipoDescuento);

	public void delete(int idTipoDescuento);

	public TipoDescuento getTipoDescuento(int idTipoDescuento);

	public List<TipoDescuento> getAllTipoDescuento();

}
