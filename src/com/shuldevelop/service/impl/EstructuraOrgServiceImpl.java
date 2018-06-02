	package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EstructuraOrgDAO;
import com.shuldevelop.model.EstructuraOrg;
import com.shuldevelop.service.EstructuraOrgService;

@Service
public class EstructuraOrgServiceImpl implements EstructuraOrgService{

	
	@Autowired
	public EstructuraOrgDAO estructuraOrgDAO;
	
	@Transactional
	public void add(EstructuraOrg centroCosto) {

		estructuraOrgDAO.add(centroCosto);
		
	}

	@Transactional
	public void edit(EstructuraOrg centroCosto) {
		estructuraOrgDAO.edit(centroCosto);


	}

	@Transactional
	public void delete(int id_estructura_org) {
		
		estructuraOrgDAO.delete(id_estructura_org);

	}

	@Transactional
	public EstructuraOrg getEstructuraOrg(int id_estructura_org) {
		return estructuraOrgDAO.getEstructuraOrg(id_estructura_org);

	}

	@Transactional
	public List<EstructuraOrg> getAllEstructuraOrg() {
		return estructuraOrgDAO.getAllEstructuraOrg();

	}
	
	@Transactional
	public List<EstructuraOrg> getDeptoEstructuraOrg() {
		return estructuraOrgDAO.getDeptoEstructuraOrg();

	}
	
	@Transactional
	public List<EstructuraOrg> getNivelEstructuraOrg() {
		return estructuraOrgDAO.getNivelEstructuraOrg();

	}
	@Transactional
	public List<EstructuraOrg> getListEstEstructuraOrg() {
		return estructuraOrgDAO.getListEstEstructuraOrg();

	}
}
