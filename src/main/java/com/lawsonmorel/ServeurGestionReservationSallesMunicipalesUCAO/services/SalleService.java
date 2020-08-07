package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Salle;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.SalleRepository;

@Service
public class SalleService {
	/*
	@Value("${page.size}")
	private Integer pageSize;
	*/
	@Autowired
	private SalleRepository salleRepository;
	
	public SalleService(SalleRepository salleRepository) {
		this.salleRepository=salleRepository;
	}
	
	/*public Page<Salle> findAll(Integer pageNumber){
		PageRequest request=new PageRequest(pageNumber-1,pageSize);
		return salleRepository.findAll(request);
	}*/
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
	
		public void update(Salle salle) {
			salleRepository.save(salle);
		}
	

}
