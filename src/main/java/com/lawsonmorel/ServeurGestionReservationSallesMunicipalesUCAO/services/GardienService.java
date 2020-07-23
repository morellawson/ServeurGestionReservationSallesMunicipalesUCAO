package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.GardienRepository;

@Service
public class GardienService {

	@Autowired
	private GardienRepository gardienRepository;
	
	
}
