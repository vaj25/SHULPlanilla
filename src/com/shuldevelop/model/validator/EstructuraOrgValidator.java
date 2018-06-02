package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.EstructuraOrg;

public class EstructuraOrgValidator implements Validator  {

	public boolean supports(Class<?> arg0) {
		
		return EstructuraOrg.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nombre", 
				"required.nombre", "El Nombre es obligatorio.");		
	
		EstructuraOrg estructuraOrg	 = (EstructuraOrg) arg0;

		if ( estructuraOrg.getUnidadOrganizacional().getId() == 0 ) {
			arg1.rejectValue("unidadOrganizacional.id", "unidadOrganizacional.id.incorrect", 
					"Seleccione una Unidad Organizacional.");
		}
		if ( estructuraOrg.getNivelEstructura().getId() == 0 ) {
			arg1.rejectValue("nivelEstructura.id", "nivelEstructura.id.incorrect", 
					"Seleccione un Nivel de Estructura.");
		}

			
	}
	
}
