package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.UnidadOrganizacional;

public interface UnidadOrganizacionalDAO {
	public void add(UnidadOrganizacional unidadorganizacional);
	public void edit(UnidadOrganizacional unidadorganizacional);
	public void delete(int idUnidadOrganizacional);
	public UnidadOrganizacional getUnidadOrganizacional(int idUnidadOrganizacional);
	public List<UnidadOrganizacional> getAllUnidadOrganizacional();

}
