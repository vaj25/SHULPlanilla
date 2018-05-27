package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.NivelEstructura;

public class NivelEstructuraValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return NivelEstructura.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nombre_nivel",
				"required.nombre_nivel","El nombre del nivel es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "numero_nivel",
				"required.numero_nivel","El numero del nivel es obligatorio");
		
		NivelEstructura nivelEstructura = (NivelEstructura) arg0;
		
		if(nivelEstructura.getNumero_nivel()<0) {
			arg1.rejectValue("numero_nivel", "numero_nivel.incorrect", "El nivel tiene que ser positivo");
		}

	}

}
