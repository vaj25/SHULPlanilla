package com.shuldevelop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shuldevelop.mail.MailMailService;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.UsuarioService;

@Controller
public class SendMailController {

	@Autowired
	private MailMailService mailService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/send-mail", method = RequestMethod.GET)
	public ModelAndView sendMail() {
		 
		 return new ModelAndView("send_mail");
		 
	}
	
	@RequestMapping(value = "/send-mail", method = RequestMethod.POST)
	public ModelAndView sendMail(HttpServletRequest request) {
		 		
		String from = request.getParameter("from");
		
		String subject = "SHULPlanilla " + from + ": " + request.getParameter("subject");
		
		String msj = request.getParameter("text");
		
		Usuario usuario = usuarioService.getUsuarioAdmin();
		
		mailService.sendMail(from, usuario.getEmpleado().getEmail_pers(), subject, msj);
		
		return new ModelAndView("login").addObject("message", "send");
		 
	}
}
