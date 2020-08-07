package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.exceptions.ResourceNotFoundException;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Materiel;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.MaterielRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MaterielController {

	@Autowired
	MaterielRepository materielRepository;
	
	@GetMapping("/materiels")
	public List<Materiel> getAllMateriels(){
		return materielRepository.findAll();
	}

	@GetMapping("/materiels/{id}")
	public ResponseEntity<Materiel> getMaterielById(@PathVariable(value="id")Long materielId)
	throws ResourceNotFoundException{
		Materiel materiel= materielRepository.findById(materielId)
				.orElseThrow(()->new ResourceNotFoundException("Matériel non trouvé avec l'Id ::"+materielId));
		
		return ResponseEntity.ok().body(materiel);
		
	}
	
	@PostMapping("/materiels")
	public Materiel createMateriel(@Valid @RequestBody Materiel materiel) {
		 
		return materielRepository.save(materiel);
		
	}
	
	@PutMapping("/materiels/{id}")
	public ResponseEntity<Materiel> updateMateriel(@PathVariable(value="id")Long materielId,
	              @Valid @RequestBody Materiel materielDetails) throws ResourceNotFoundException{
		Materiel materiel =materielRepository.findById(materielId)
				.orElseThrow(()->new ResourceNotFoundException("Matéreil  non trouvé avec l'id ::"+materielId));
		
		materiel.setId(materielDetails.getId());
		materiel.setEtat(materielDetails.getEtat());
		materiel.setNom(materielDetails.getNom());
		materiel.setReferene(materielDetails.getReferene());
		materiel.setTarif(materielDetails.getTarif());
		
	
		
		final Materiel updateMateriel=materielRepository.save(materiel);
		return ResponseEntity.ok(updateMateriel);
	}
	
	@DeleteMapping("/materiels/{id}")
	public Map<String , Boolean> deleteMateriel(@PathVariable(value="id")Long materielId)
	   throws ResourceNotFoundException{
		
		Materiel materiel= materielRepository.findById(materielId)
				.orElseThrow(()->new ResourceNotFoundException("Materiel  non trouvé avec l'id :: "+materielId));
		
		
		materielRepository.delete(materiel);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Supprimé", Boolean.TRUE);
		
		
		return response;
	}
	
}
