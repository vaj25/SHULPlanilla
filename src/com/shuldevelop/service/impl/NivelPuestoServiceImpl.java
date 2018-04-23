package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.NivelPuestoDAO;
import com.shuldevelop.model.NivelPuesto;
import com.shuldevelop.service.NivelPuestoService;

@Service
public class NivelPuestoServiceImpl implements NivelPuestoService {

	@Autowired
	public NivelPuestoDAO tipoPuestoDAO;
	
	@Transactional
	public void add(NivelPuesto tipoPuesto) {
		
		tipoPuestoDAO.add(tipoPuesto);

	}

	@Transactional
	public void edit(NivelPuesto tipoPuesto) {
		
		tipoPuestoDAO.edit(tipoPuesto);

	}

	@Transactional
	public void delete(int idTipoPuesto) {
		
		tipoPuestoDAO.delete(idTipoPuesto);

	}

	@Transactional
	public NivelPuesto getTipoPuesto(int idTipoPuesto) {
		
		return tipoPuestoDAO.getTipoPuesto(idTipoPuesto);
		
	}

	@Transactional
	public List<NivelPuesto> getAllTipoPuesto() {
		
		return tipoPuestoDAO.getAllTipoPuesto();
		
	}

}
