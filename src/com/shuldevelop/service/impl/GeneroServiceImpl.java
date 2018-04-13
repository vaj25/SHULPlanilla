package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.GeneroDAO;
import com.shuldevelop.model.Genero;
import com.shuldevelop.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	public GeneroDAO generoDAO;
	
	@Transactional
	public void add(Genero genero) {
		
		generoDAO.add(genero);
		
	}

	@Transactional
	public void edit(Genero genero) {
		generoDAO.edit(genero);

	}

	@Transactional
	public void delete(int idGenero) {
		generoDAO.delete(idGenero);

	}

	@Transactional
	public Genero getGenero(int idGenero) {
		return generoDAO.getGenero(idGenero);
	}

	@Transactional
	public List<Genero> getAllGenero() {
		return generoDAO.getAllGenero();

	}

}
