package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.NivelPuesto;

public class NivelPuestoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return NivelPuesto.class.isAssignableFrom(arg0);
		
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "numeroNivel", 
				"required.numeroNivel", "El número de nivel es obligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "salarioMinimo", 
				"required.salarioMinimo", "El salario mínimo es obligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "salarioMaximo", 
				"required.salarioMaximo", "El salario máximo es obligatorio.");
		
		NivelPuesto tipoPuesto = (NivelPuesto) arg0;
		
		if ( tipoPuesto.getNumeroNivel() < 0 ) {
			arg1.rejectValue("numeroNivel", "numeroNivel.incorrect", 
					"El número nivel tiene que ser positivo.");
		}
		
		if ( tipoPuesto.getSalarioMinimo() < 0 ) {
			arg1.rejectValue("salarioMinimo", "salarioMinimo.incorrect", 
					"El salario mínimo tiene que ser positivo.");
		}
		
		if ( tipoPuesto.getSalarioMaximo() < 0 ) {
			arg1.rejectValue("salarioMaximo", "salarioMaximo.incorrect", 
					"El salario máximo tiene que ser positivo.");
		}
		
	}

}
