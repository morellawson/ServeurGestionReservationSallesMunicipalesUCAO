package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Visiteur;


@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur,Long> {

}
