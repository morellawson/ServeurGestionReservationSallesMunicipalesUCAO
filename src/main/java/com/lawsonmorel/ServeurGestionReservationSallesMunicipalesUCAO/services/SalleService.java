package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Salle;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.SalleRepository;

@Service
public class SalleService {
	
	@Autowired
	private SalleRepository salleRepository;
	
	   //Recupérer la liste de toutes les salles 
		public List<Salle> findAll(){
			return salleRepository.findAll();
		}	
		
		//Récupérer une salle par son Id
		public Optional<Salle> getSalle(Long id) {
			return salleRepository.findById(id);
		}	
		
		//Supprimer une salle
		public void delete(Long id) {
			salleRepository.deleteById(id);
		}
		
		//Ajouter une salle à la liste
		public void save( Salle salle) {
			salleRepository.save(salle);
		}
	
	

}
