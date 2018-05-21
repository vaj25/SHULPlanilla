package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.model.TipoDescuento;
import com.shuldevelop.DAO.TipoDescuentoDAO;
import com.shuldevelop.service.TipoDescuentoService;

@Service
public class TipoDescuentoServiceImpl implements TipoDescuentoService {

	@Autowired
	public TipoDescuentoDAO tipoDescuentoDAO;

	@Transactional
	public void add(TipoDescuento tipoDescuento) {

		tipoDescuentoDAO.add(tipoDescuento);

	}

	@Transactional
	public void edit(TipoDescuento tipoDescuento) {

		tipoDescuentoDAO.edit(tipoDescuento);

	}

	@Transactional
	public void delete(int idTipoDescuento) {

		tipoDescuentoDAO.delete(idTipoDescuento);

	}

	@Transactional
	public TipoDescuento getTipoDescuento(int idTipoDescuento) {

		return tipoDescuentoDAO.getTipoDescuento(idTipoDescuento);

	}

	@Transactional
	public List<TipoDescuento> getAllTipoDescuento() {

		return tipoDescuentoDAO.getAllTipoDescuento();

	}

}
