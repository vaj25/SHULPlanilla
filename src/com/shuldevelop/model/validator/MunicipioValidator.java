package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.Municipio;

public class MunicipioValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Municipio.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nombre",
				"required.nombre","El nombre es obligatorio");
		
		Municipio municipio = (Municipio) arg0;
		if(municipio.getDepartamento().getId()==0) {
			arg1.rejectValue("departamento.id", "departamento.incorrect", "Debe seleccionar un departamento");
		}

	}

}
