package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.NivelEstructura;

public interface NivelEstructuraService {
	public void add(NivelEstructura nivelestructura);
	public void edit(NivelEstructura nivelestructura);
	public void delete(int idNivelEstructura);
	public NivelEstructura getNivelEstructura(int idNivelEstructura);
	public List<NivelEstructura> getAllNivelEstructura();
}
