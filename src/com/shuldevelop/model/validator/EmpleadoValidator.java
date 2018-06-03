package com.shuldevelop.model.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.Empleado;

public class EmpleadoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Empleado.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "primer_nombre",
				"required.primer_nombre","El primer nombre es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "segundo_nombre",
				"required.segundo_nombre","El segundo nombre es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "primer_apellido",
				"required.primer_apellido","El primer apellido es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "segundo_apellido",
				"required.segundo_apellido","El segundo apellido es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "fecha_nacimiento",
				"required.fecha_nacimiento","El Fecha de nacimiento es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "fecha_ingreso",
				"required.fecha_ingreso","El fecha_ingreso es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nit",
				"required.nit","El NIT es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "isss",
				"required.isss","El ISSS es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nup",
				"required.nup","El NUP es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "doc_identidad",
				"required.doc_identidad","El documento de identidad es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "email_pers",
				"required.email_pers","El Email es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "email_inst",
				"required.email_inst","El email inst es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "direccion.numCasa",
				"required.direccion.numCasa","El numero de casa es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "direccion.numCalle",
				"required.direccion.numCalle","El numero de Calle es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "direccion.colonia",
				"required.direccion.colonia","El numero de Calle es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "direccion.avenida",
				"required.direccion.avenida","La avenida es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "direccion.poligono",
				"required.direccion.poligono","El poligono es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "direccion.pasaje",
				"required.direccion.pasaje","El pasaje es obligatorio");
		
		Empleado empleado = (Empleado) arg0;
		
		if(empleado.getEstadoCivil().getId()==0) {
			arg1.rejectValue("estadoCivil.id", "estadoCivil.incorrect", "Seleccione un estado civil");
		}
		
		if(empleado.getGenero().getId()==0) {
			arg1.rejectValue("genero.id", "genero.incorrect", "Seleccione el genero");
		}
		
		if(empleado.getTipoDocIdentidad().getId()==0) {
			arg1.rejectValue("tipoDocIdentidad.id", "tipoDocIdentidad.incorrect", "Seleccione un estado civil");
		}
		
		if(empleado.getProfesionOficio().getId()==0) {
			arg1.rejectValue("profesionOficio.id", "profesionOficio.incorrect", "Seleccione un estado civil");
		}
		
		
		
		
		
		

	}

}
