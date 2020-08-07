package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Employe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 150)
	private String nom;
	
	@NotBlank
	@Size(max = 120)
	private String prenom;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	
	public Employe() {
		
	}

	public Employe(String nom, String prenom,String email) {	
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
