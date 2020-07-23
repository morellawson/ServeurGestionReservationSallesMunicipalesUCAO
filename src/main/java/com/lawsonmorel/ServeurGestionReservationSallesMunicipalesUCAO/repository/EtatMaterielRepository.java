package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.EMaterielEtat;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.EtatMateriel;

@Repository
public interface EtatMaterielRepository extends JpaRepository<EtatMateriel,Integer> {

	Optional<EtatMateriel> findByName(EMaterielEtat name);
}
