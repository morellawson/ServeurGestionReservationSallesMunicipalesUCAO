package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long>{
        
	//Page<Salle> findAll(Integer pageNumber);
}
