package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.EstructuraOrg;

public interface EstructuraOrgDAO {

	public void add(EstructuraOrg estructuraOrg);
	
	public void edit(EstructuraOrg estructuraOrg);

	public void delete(int id_estructura_org);

	public EstructuraOrg getEstructuraOrg(int id_estructura_org);
	
	public List<EstructuraOrg> getAllEstructuraOrg();
	
	public List<EstructuraOrg> getDeptoEstructuraOrg();
	
	public List<EstructuraOrg> getNivelEstructuraOrg();

	public List<EstructuraOrg> getListEstEstructuraOrg(int id_estructura_org);

}
	