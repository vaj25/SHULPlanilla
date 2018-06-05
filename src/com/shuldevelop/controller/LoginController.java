package com.shuldevelop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shuldevelop.mail.MailMailService;

@Controller
public class LoginController {
	
	@Autowired
	private MailMailService mailService;
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
    	        
//        String from = "alb2594@gmail.com";
//        
//        String to = "valb4991@hotmail.com";
//        
//        mailService.sendMail(from, to, "Prueba", "Prueba");
        
        return new ModelAndView("login");
    }
	
}
