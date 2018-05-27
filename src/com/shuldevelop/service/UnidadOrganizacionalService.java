package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.UnidadOrganizacional;

public interface UnidadOrganizacionalService {
	public void add(UnidadOrganizacional unidadorganizacional);
	public void edit(UnidadOrganizacional unidadorganizacional);
	public void delete(int idUnidadOrganizacional);
	public UnidadOrganizacional getUnidadOrganizacional(int idUnidadOrganizacional);
	public List<UnidadOrganizacional> getAllUnidadOrganizacional();
}
