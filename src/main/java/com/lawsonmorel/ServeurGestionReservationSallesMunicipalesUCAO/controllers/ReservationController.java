package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.exceptions.ResourceNotFoundException;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Reservation;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Salle;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.ReservationRepository;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.VisiteurRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReservationController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	VisiteurRepository visisteurRepository;
	
	
	@GetMapping("/reservations/{id}")
	public ResponseEntity<Reservation> getReservationById(@PathVariable(value = "id") Long reservationId)
			throws ResourceNotFoundException {
		Reservation reservation = reservationRepository.findById(reservationId)
		
				.orElseThrow(() -> new ResourceNotFoundException("Reservation non trouvée pour  id :: " + reservationId));
		return ResponseEntity.ok().body(reservation);
	}
	
	@PostMapping("/reservation")
	public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation)  
			throws JsonParseException , JsonMappingException , Exception{
		reservationRepository.save(reservation);
		Salle salle=reservation.getSalle();
		
		salle.setEtat("A RESERVE");
		reservation.setSalle(reservation.getSalle());
		reservationRepository.save(reservation);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		  
		
	@DeleteMapping("/reservations/{id}")
	public ResponseEntity<Reservation>  deleteReservation(@PathVariable(value = "id") Long reservationId)
	{
		Optional<Reservation> reservationInfo = reservationRepository.findById(reservationId);
	  if (reservationInfo.isPresent()) {
		  System.out.println("Reservation 11");
		  Reservation reservation = reservationInfo.get();
		  
		  Salle salle= reservation.getSalle();
		  salle.setEtat("LIBRE");
		  
		
		  reservationRepository.delete(reservation);
		  return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	 @DeleteMapping("/comms/delete")
	  public ResponseEntity<String> deleteAllReservations(){
	    System.out.println("Suppression de toutes les réservations.....");
	    reservationRepository.deleteAll();
	    return new ResponseEntity<>("Toutes les réservations ont été supprimées", HttpStatus.OK);
	  }
	
	  @PutMapping("/reservations/{id}")
	  public ResponseEntity<Reservation> updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation) {
	    System.out.println("Update  reservation with ID = " + id + "...");
	    Optional<Reservation> reservationInfo = reservationRepository.findById(id);
	    if (reservationInfo.isPresent()) {
	    	Reservation reserv = reservationInfo.get();
	    	reserv.setSalle(reservation.getSalle());
	      return new ResponseEntity<>(reservationRepository.save(reservation), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

}
