package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Reservation;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.ReservationRepository;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.SalleRepository;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.VisiteurRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private SalleRepository salleRepository;
	
	@Autowired
	private VisiteurRepository visiteurRepository;
	
	
	public ReservationService() {
	
	}

	public Reservation createReservation(String salle,String visiteur) {
		Reservation reservation=new Reservation();
		return reservation;
	}
	
	public List<Reservation> searchReservations(LinkedHashMap<String, String> parameters) throws Exception {
		List<Reservation> reservations = reservationRepository.searchReservations(parameters);
		return reservations;
	}
}
