package com.shuldevelop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuldevelop.DAO.NivelEstructuraDAO;
import com.shuldevelop.model.NivelEstructura;
import com.shuldevelop.service.NivelEstructuraService;
@Service
public class NivelEstructuraServiceImpl implements NivelEstructuraService {
	@Autowired
	private NivelEstructuraDAO nivelEstructuraDAO;
	
	@Transactional
	public void add(NivelEstructura nivelestructura) {
		nivelEstructuraDAO.add(nivelestructura);

	}

	@Transactional
	public void edit(NivelEstructura nivelestructura) {
		nivelEstructuraDAO.edit(nivelestructura);

	}

	@Transactional
	public void delete(int idNivelEstructura) {
		nivelEstructuraDAO.delete(idNivelEstructura);

	}

	@Transactional
	public NivelEstructura getNivelEstructura(int idNivelEstructura) {
		return nivelEstructuraDAO.getNivelEstructura(idNivelEstructura);
	}

	@Transactional
	public List<NivelEstructura> getAllNivelEstructura() {
		return nivelEstructuraDAO.getAllNivelEstructura();
	}

}
