package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Mail;

public interface MailRepository {
	
	public void sendEmail(Mail mail);

}
