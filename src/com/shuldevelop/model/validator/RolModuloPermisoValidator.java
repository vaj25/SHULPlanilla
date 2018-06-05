package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shuldevelop.model.RolModuloPermiso;

public class RolModuloPermisoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return RolModuloPermiso.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		RolModuloPermiso permiso = (RolModuloPermiso) arg0;
		
		if(permiso.getModulo().getId() == 0) {
			arg1.rejectValue("modulo.id", "modulo.incorrect", "Seleccione un modulo.");
		}

	}

}
