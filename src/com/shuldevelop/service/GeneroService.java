package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.Genero;

public interface GeneroService {

	public void add(Genero genero);
	
	public void edit(Genero genero);

	public void delete(int idGenero);

	public Genero getGenero(int idGenero);
	
	public List<Genero> getAllGenero();
	
	
}
