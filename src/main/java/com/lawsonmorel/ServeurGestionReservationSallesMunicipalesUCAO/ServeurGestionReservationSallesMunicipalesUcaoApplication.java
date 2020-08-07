package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Mail;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services.MailService;

@SpringBootApplication
public class ServeurGestionReservationSallesMunicipalesUcaoApplication {

	@PostConstruct
	void setUTCTimezone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	public static void main(String[] args) {
		
	   Mail mail=new Mail();
		mail.setMailFrom("morellatel@gmail.com");
		mail.setMailTo("kristobalnera@gmail.com");
		mail.setMailSubject("Demande de Reservation de salles en attente de traitement");
		
		mail.setMailContent("Bonjour, \nVotre demande de réservation de salles à la Mairie de Lomé est en cours d'examen par nos services.\nLa réponse "
				+ "vous sera bientôt notifiée.\nCordialement,\n\nL'équipe Réservation de la Mairie de Lomé.");
		
		//mail.setAttachments();
		ApplicationContext ctx =SpringApplication.run(ServeurGestionReservationSallesMunicipalesUcaoApplication.class, args);
		MailService mailService=(MailService)ctx.getBean("mailService");
		mailService.sendEmail(mail);
		//SpringApplication.run(ServeurGestionReservationSallesMunicipalesUcaoApplication.class, args);
	}

}
