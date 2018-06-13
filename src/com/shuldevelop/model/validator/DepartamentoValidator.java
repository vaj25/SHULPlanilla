package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.Departamento;

public class DepartamentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Departamento.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nombre",
				"required.nombre","El nombre es obligatorio");
		Departamento departamento = (Departamento) arg0;
		if(departamento.getZona().getId()==0) {
			arg1.rejectValue("zona.id", "zona.incorrect", "Seleccione una zona");
		}

	}

}
