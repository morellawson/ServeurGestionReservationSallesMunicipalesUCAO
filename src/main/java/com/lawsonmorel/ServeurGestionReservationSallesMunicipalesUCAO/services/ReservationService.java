package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services;

import java.util.ArrayList;
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
	
	
	public List getAllReservation() {
		
		List reservations =new ArrayList<>();
		reservationRepository.findAll().forEach(reservations::add);
		return reservations;
	}

/*	public Reservation getReservation(Long id) {
		return reservationRepository.findOne(id);
	}*/
	
	public void addReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	public void updateReservation(Long id,Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
	}
}
