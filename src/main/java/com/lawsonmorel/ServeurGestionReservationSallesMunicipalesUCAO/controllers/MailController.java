package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Mail;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services.MailService;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services.MailServiceImpl;

@Controller
@EnableAutoConfiguration
public class MailController {
	
	@Autowired
	private MailServiceImpl mailService;
	
	Mail mail;
	
	private String sendEmail() {
		try {
			mailService.sendEmail(mail);
			return "mail sent successfully";
		}catch(MailException e) {
			e.printStackTrace();
		}
		return "thanks";
	}

}
