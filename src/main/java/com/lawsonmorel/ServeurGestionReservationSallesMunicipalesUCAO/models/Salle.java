package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models;


import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="salles")
public class Salle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 50)
	private String nom;
	
	@NotBlank
	@Size(max = 250)
	private String adresse;
	

	private Integer capaciteMax;
	
	private Integer capaciteMin;
	
	@NotBlank
	@Size(max = 250)
	private String description;
	
	private Double prixParticulier;
	
	private Double prixAsso;
	
	private Double surface;
	
	@NotBlank
	@Size(max = 150)
	private String etat;
	
	@OneToMany(mappedBy="salle",fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private List<Materiel> materiels;
	
	
	
	@OneToOne(mappedBy="salle",fetch=FetchType.LAZY,
			             cascade=CascadeType.ALL)
	private Reservation reservation;
	
	private String fileName;
	


	public Salle() {
		
	}

	public Salle(String nom, String adresse, Integer capaciteMax,Integer capaciteMin, String description, Double prixParticulier, Double prixAsso,
			Double surface, String etat) {

		this.nom = nom;
		this.adresse = adresse;
		this.capaciteMax = capaciteMax;
		this.capaciteMin = capaciteMin;
		this.description = description;
		this.prixParticulier = prixParticulier;
		this.prixAsso = prixAsso;
		this.surface = surface;
		this.etat = etat;
	}
	
	

	public Salle(Long id,  String nom, String adresse,
			Integer capaciteMax, Integer capaciteMin, String description,
			Double prixParticulier, Double prixAsso, Double surface,  String etat,
			List<Materiel> materiels, String fileName) {
		
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.capaciteMax = capaciteMax;
		this.capaciteMin = capaciteMin;
		this.description = description;
		this.prixParticulier = prixParticulier;
		this.prixAsso = prixAsso;
		this.surface = surface;
		this.etat = etat;
		this.materiels = materiels;
		this.fileName = fileName;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getCapaciteMax() {
		return capaciteMax;
	}

	public void setCapaciteMax(Integer capaciteMax) {
		this.capaciteMax = capaciteMax;
	}

	public Integer getCapaciteMin() {
		return capaciteMin;
	}

	public void setCapaciteMin(Integer capaciteMin) {
		this.capaciteMin = capaciteMin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrixParticulier() {
		return prixParticulier;
	}

	public void setPrixParticulier(Double prixParticulier) {
		this.prixParticulier = prixParticulier;
	}

	public Double getPrixAsso() {
		return prixAsso;
	}

	public void setPrixAsso(Double prixAsso) {
		this.prixAsso = prixAsso;
	}

	public Double getSurface() {
		return surface;
	}

	public void setSurface(Double surface) {
		this.surface = surface;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	public List<Materiel> getMateriels() {
		return materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", capaciteMax=" + capaciteMax
				+ ", capaciteMin=" + capaciteMin + ", description=" + description + ", prixParticulier="
				+ prixParticulier + ", prixAsso=" + prixAsso + ", surface=" + surface + ", etat=" + etat
				+ ", materiels=" + materiels + ", reservation=" + reservation + ", fileName=" + fileName + "]";
	}

	
	

}
