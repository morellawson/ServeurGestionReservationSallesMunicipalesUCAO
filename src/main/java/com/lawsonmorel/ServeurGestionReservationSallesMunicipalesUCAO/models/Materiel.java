package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="materiels")
public class Materiel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 150)
	private String nom;
	
	@NotBlank
	@Size(max = 150)
	private String referene;
	
	@NotBlank
	@Size(max = 100)
	private String etat;
	

	private Double tarif;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="salle_id",nullable=false)
	private Salle salle;


	public Materiel() {
		
	}
	
	

	public Materiel(String nom, String referene,String etat, Double tarif) {
	
		this.nom = nom;
		this.referene = referene;
		this.etat = etat;
		this.tarif = tarif;
	}
	
	
	public Materiel(@NotBlank @Size(max = 150) String nom, @NotBlank @Size(max = 150) String referene,
			@NotBlank @Size(max = 100) String etat, Double tarif, Salle salle) {
		super();
		this.nom = nom;
		this.referene = referene;
		this.etat = etat;
		this.tarif = tarif;
		this.salle = salle;
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


	public String getReferene() {
		return referene;
	}


	public void setReferene(String referene) {
		this.referene = referene;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public Double getTarif() {
		return tarif;
	}


	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	

}
