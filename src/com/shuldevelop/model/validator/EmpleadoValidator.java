package com.shuldevelop.model.validator;


import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.regex.Pattern;

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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "direccion.colonia",
				"required.direccion.colonia","El numero de Calle es obligatorio");
		
		
		
		
		Empleado empleado = (Empleado) arg0;
		
		if(empleado.getEstadoCivil().getId()==0) {
			arg1.rejectValue("estadoCivil.id", "estadoCivil.incorrect", "Seleccione un estado civil");
		}
		
		if(empleado.getGenero().getId()==0) {
			arg1.rejectValue("genero.id", "genero.incorrect", "Seleccione el genero");
		}
		
		if(empleado.getTipoDocIdentidad().getId()==0) {
			arg1.rejectValue("tipoDocIdentidad.id", "tipoDocIdentidad.incorrect", "Seleccione un tipo de documento");
		}
		
		if(empleado.getProfesionOficio().getId()==0) {
			arg1.rejectValue("profesionOficio.id", "profesionOficio.incorrect", "Seleccione una profesion");
		}
		
		if(empleado.getTipoDocIdentidad().getId()==1) {
			if(empleado.getDoc_identidad().length() < 10 || empleado.getDoc_identidad().length() > 10) {
				arg1.rejectValue("doc_identidad", "doc_identidad.incorrect", "Formato invalido para Dui");
			}
		}
		
		if(empleado.getFecha_ingreso()!=null && empleado.getFecha_ingreso()!=null) {
		LocalDate fechaNac=empleado.getFecha_nacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate fechaIng=empleado.getFecha_ingreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period periodo = Period.between(fechaNac, fechaIng);
		if(periodo.getYears()<18) {
			arg1.rejectValue("fecha_nacimiento", "fecha_nacimiento.incorrect", "Debe ser mayor de 18 años");
		}
		}
		
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	            Pattern.CASE_INSENSITIVE);
		
		if(!(pattern.matcher(empleado.getEmail_pers()).matches())) {
			arg1.rejectValue("email_pers", "email_pers.incorrect", "Formato de email invalido");
		}
		
		if(!(pattern.matcher(empleado.getEmail_inst()).matches())) {
			arg1.rejectValue("email_inst", "email_inst.incorrect", "Formato de email invalido");
		}
		
		String str=Integer.toString(empleado.getIsss());
		if(str.length()!=9) {
			arg1.rejectValue("isss", "isss.incorrect", "Formato invalido para No. ISSS");
		}
		
		String str2=Long.toString(empleado.getNup());
		if(str2.length()!=12) {
			arg1.rejectValue("nup", "nup.incorrect", "Formato invalido para NUP");
		}
		
		if(empleado.getNit().length()!=17) {
			arg1.rejectValue("nit", "nit.incorrect", "Formato no valido para NIT");
		}
		
		Pattern pattern1=Pattern.compile("^[0-9]{4}-{1}[0-9]{6}-{1}[0-9]{3}-{1}[0-9]{1}$");
		if(!(pattern1.matcher(empleado.getNit()).matches())) {
			arg1.rejectValue("nit", "nit.incorrect", "Formato incorrecto para NIT");
		}
		
		Pattern pattern2 = Pattern.compile("^[a-zA-zñ ]+$");
		if(!(pattern2.matcher(empleado.getPrimer_nombre()).matches())) {
			arg1.rejectValue("primer_nombre", "primer_nombre.invalid", "Debe introducir un nombre");
		}
		
		if(!(pattern2.matcher(empleado.getSegundo_nombre()).matches())) {
			arg1.rejectValue("segundo_nombre", "segundo_nombre.invalid", "Debe introducir un nombre");
		}
		
		if(!(pattern2.matcher(empleado.getPrimer_apellido()).matches())) {
			arg1.rejectValue("primer_apellido", "primer_apellido.invalid", "Debe introducir un nombre");
		}
		
		if(!(pattern2.matcher(empleado.getSegundo_apellido()).matches())) {
			arg1.rejectValue("segundo_appellido", "segundo_apellido.invalid", "Debe introducir un nombre");
		}
		
		if(!(pattern2.matcher(empleado.getApellido_casada()).matches())) {
			arg1.rejectValue("apellido_casada", "apellido_casada.invalid", "Debe introducir un nombre");
		}
		
		

	}

}
