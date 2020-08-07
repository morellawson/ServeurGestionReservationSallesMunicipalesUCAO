package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
 
	//public void searchReservation();
}
