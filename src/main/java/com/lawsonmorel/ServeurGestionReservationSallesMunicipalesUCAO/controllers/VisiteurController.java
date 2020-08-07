package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.exceptions.ResourceNotFoundException;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Visiteur;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.VisiteurRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VisiteurController {
	
	
	@Autowired
	VisiteurRepository visiteurRepository;
	
	 @GetMapping("/visiteurs")
	  public List<Visiteur> getAllVisiteurs() {
	    System.out.println("Get all Visiteurs...");
	 
	    List<Visiteur> visiteurs = new ArrayList<>();
	    visiteurRepository.findAll().forEach(visiteurs::add);
	 
	    return visiteurs;
	  }
	
	@GetMapping("/visiteurs/{id}")
	public ResponseEntity<Visiteur> getVisiteurById(@PathVariable(value = "id") Long visiteurId)
			throws ResourceNotFoundException {
		Visiteur visiteur = visiteurRepository.findById(visiteurId)
				.orElseThrow(() -> new ResourceNotFoundException("Visiteur non trouvé avec l'id :: " + visiteurId));
		return ResponseEntity.ok().body(visiteur);
	}

	@PostMapping("/visiteurs")
	public Visiteur createVisiteur(@Valid @RequestBody Visiteur visiteur) {
		return visiteurRepository.save(visiteur);
	}
	

	@DeleteMapping("/visiteurs/{id}")
	public Map<String, Boolean> deleteVisiteur(@PathVariable(value = "id") Long visiteurId)
			throws ResourceNotFoundException {
		Visiteur visiteur = visiteurRepository.findById(visiteurId)
				.orElseThrow(() -> new ResourceNotFoundException("Visiteur non trouvé avec l'd :: " + visiteurId));

		visiteurRepository.delete(visiteur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	  @DeleteMapping("/visiteurs/delete")
	  public ResponseEntity<String> deleteAllVisiteurs() {
	    System.out.println("Delete All Visiteurs...");
	 
	    visiteurRepository.deleteAll();
	 
	    return new ResponseEntity<>("All visiteurs have been deleted!", HttpStatus.OK);
	  }

}
