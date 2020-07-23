package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="visiteurs")
public class Visiteur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 30)
	private String nom;
	
	@NotBlank
	@Size(max = 50)
	private String prenom;
	
	@NotBlank
	@Size(max = 50)
	private Integer telephone;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 30)
	private String type;
	
	@OneToOne(mappedBy="visiteur",fetch=FetchType.LAZY,
            cascade=CascadeType.ALL)
   private Reservation reservation;

	public Visiteur() {
		
	}

	public Visiteur( String nom,  Integer telephone,String email, String type) {
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.type = type;
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

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	

}
