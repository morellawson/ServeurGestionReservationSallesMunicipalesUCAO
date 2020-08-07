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
import org.springframework.web.bind.annotation.RestController;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.exceptions.ResourceNotFoundException;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Employe;
//import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.EmployeRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeController {
	/*@Autowired
	private EmployeRepository employeRepository;
	
	@GetMapping("/employes")
	public List<Employe> getAllEmployes(){
		return employeRepository.findAll();
	}

	@GetMapping("/employes/{id}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable(value="id")Long employeId)
	throws ResourceNotFoundException{
		Employe employe = employeRepository.findById(employeId)
				.orElseThrow(()->new ResourceNotFoundException("Employé non trouvé avec l'Id ::"+employeId));
		
		return ResponseEntity.ok().body(employe);
		
	}
	
	@PostMapping("/employes")
	public Employe createEmploye(@Valid @RequestBody Employe employe) {
		 
		return employeRepository.save(employe);
		
	}*/
/*	
	@PutMapping("/employes/{id}")
	public ResponseEntity<Employe> updateEmploye(@PathVariable(value="id")Long employeId,
	              @Valid @RequestBody Employe employeDetails) throws ResourceNotFoundException{
		
		Employe employe = employeRepository.findById(employeId)
				.orElseThrow(()->new ResourceNotFoundException("Employé non trouvé avec l'id ::"+employeId));
		
		employe.setNom(employeDetails.getNom());
		employe.setPrenom(employeDetails.getPrenom());
		employe.setRoles(employeDetails.getRoles());
		employe.setUsername(employeDetails.getUsername());
		employe.setPassword(employeDetails.getPassword());
		
		final Employe updateEmploye=employeRepository.save(employe);
		return ResponseEntity.ok(updateEmploye);
	}
	
	@DeleteMapping("/employes/{id}")
	public Map<String , Boolean> deleteEmploye(@PathVariable(value="id")Long employeId)
	   throws ResourceNotFoundException{
		
		Employe employe= employeRepository.findById(employeId)
				.orElseThrow(()->new ResourceNotFoundException("Employé non trouvé avec l'id :: "+employeId));
		
		
		employeRepository.delete(employe);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Supprimé", Boolean.TRUE);
		
		
		return response;
	}*/
}
