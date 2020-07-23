package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Visiteur;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.VisiteurRepository;

@Service
public class VisiteurService {
	
	@Autowired
	private VisiteurRepository visiteurRepository;
	
	public List<Visiteur> findAll() {
		return visiteurRepository.findAll();
	}

	public Optional<Visiteur> getVisiteur(Long id) {
		return visiteurRepository.findById(id);
	}
}
