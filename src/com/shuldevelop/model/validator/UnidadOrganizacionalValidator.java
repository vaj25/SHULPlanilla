package com.shuldevelop.model.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.UnidadOrganizacional;

public class UnidadOrganizacionalValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return UnidadOrganizacional.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "unidad_org", "unidadOrganizacional.unidad_org.invalid","El nombre es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "direccion", "unidadOrganizacional.direccion.invalid","La direccion es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "representante", "unidadOrganizacional.representante.invalid","El representante obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nit", "unidadOrganizacional.nit.invalid","El NIT es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nic", "unidadOrganizacional.nic.invalid","El nic es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "telefono", "unidadOrganizacional.telefono.invalid","El Telefono es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "email_pers", "unidadOrganizacional.email_pers.invalid","El Email es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "site_web", "unidadOrganizacional.site_web.invalid","El sitio web es obligatorio");
		
		UnidadOrganizacional unidadOrganizacional = (UnidadOrganizacional) arg0;
		
		if(unidadOrganizacional.getNit().length() > 14) {
			arg1.rejectValue("nit", "unidad.nit.invalid", "El nit posee un formato no valido");
		}
		
		 Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
		            Pattern.CASE_INSENSITIVE);
		 
		 if (!(pattern.matcher(unidadOrganizacional.getEmail_pers()).matches())) {
	         arg1.rejectValue("email_pers", "unidadOrganizacional.email_pers.invalid","El email posee un formato no valido");
	      }

	}

}
