package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServeurGestionReservationSallesMunicipalesUcaoApplication {

	@PostConstruct
	void setUTCTimezone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	public static void main(String[] args) {
		SpringApplication.run(ServeurGestionReservationSallesMunicipalesUcaoApplication.class, args);
	}

}
