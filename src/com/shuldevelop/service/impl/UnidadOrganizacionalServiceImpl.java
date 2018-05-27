package com.shuldevelop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuldevelop.DAO.UnidadOrganizacionalDAO;
import com.shuldevelop.model.UnidadOrganizacional;
import com.shuldevelop.service.UnidadOrganizacionalService;
@Service
public class UnidadOrganizacionalServiceImpl implements UnidadOrganizacionalService {
	@Autowired
	private UnidadOrganizacionalDAO unidadOrganizacionalDAO;
	
	@Transactional
	public void add(UnidadOrganizacional unidadorganizacional) {
		unidadOrganizacionalDAO.add(unidadorganizacional);

	}

	@Transactional
	public void edit(UnidadOrganizacional unidadorganizacional) {
		unidadOrganizacionalDAO.edit(unidadorganizacional);

	}

	@Transactional
	public void delete(int idUnidadOrganizacional) {
		unidadOrganizacionalDAO.delete(idUnidadOrganizacional);

	}

	@Transactional
	public UnidadOrganizacional getUnidadOrganizacional(int idUnidadOrganizacional) {
		return unidadOrganizacionalDAO.getUnidadOrganizacional(idUnidadOrganizacional);
	}

	@Transactional
	public List<UnidadOrganizacional> getAllUnidadOrganizacional() {
		return unidadOrganizacionalDAO.getAllUnidadOrganizacional();
	}

}
