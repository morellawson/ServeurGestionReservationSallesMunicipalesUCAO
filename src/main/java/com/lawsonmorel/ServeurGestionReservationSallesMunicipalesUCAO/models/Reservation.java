package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 120)
	private String typeManif;
	
	@NotBlank
	@Size(max = 120)
	private String nomManif;
	
	@NotBlank
	@Size(max = 100)
	private String etat;
	
	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="salle_id",nullable=false)
    private Salle salle;
	

	@OneToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="visiteur_id",nullable=false)
    private Visiteur visiteur;
	
	@Column(name="date_debut_reservation")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy",timezone="UTC")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateDeutReservation;
	
	@Column(name="heure_debut_reservation")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="HH:mm:ss")
	@Temporal(TemporalType.TIME)
	@NotNull
	private Date heureDeutReservation;
	
	@Column(name="date_fin_reservation")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy",timezone="UTC")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateFinReservation;
	
	@Column(name="heure_fin_reservation")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="HH:mm:ss")
	@Temporal(TemporalType.TIME)
	@NotNull
	private Date heureFinReservation;
	
	@Column(name="date_reservation")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateReservation;
	
	private Integer nbrePerson;
	
	private Boolean isMaterielReserve;

	

	public Reservation() {
		
	}

	public Reservation( String nomManif, Salle salle, Visiteur visiteur,
			Date dateDeutReservation, Date heureDeutReservation, Date dateFinReservation,
			 Date heureFinReservation,  Date dateReservation, Integer nbrePerson,
			Boolean isMaterielReserve) {
		
		this.nomManif = nomManif;
		this.salle = salle;
		this.visiteur = visiteur;
		this.dateDeutReservation = dateDeutReservation;
		this.heureDeutReservation = heureDeutReservation;
		this.dateFinReservation = dateFinReservation;
		this.heureFinReservation = heureFinReservation;
		this.dateReservation = dateReservation;
		this.nbrePerson = nbrePerson;
		this.isMaterielReserve = isMaterielReserve;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTypeManif() {
		return typeManif;
	}



	public void setTypeManif(String typeManif) {
		this.typeManif = typeManif;
	}



	public String getNomManif() {
		return nomManif;
	}



	public void setNomManif(String nomManif) {
		this.nomManif = nomManif;
	}



	public String getEtat() {
		return etat;
	}



	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Visiteur getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}

	public Date getDateDeutReservation() {
		return dateDeutReservation;
	}

	public void setDateDeutReservation(Date dateDeutReservation) {
		this.dateDeutReservation = dateDeutReservation;
	}

	public Date getHeureDeutReservation() {
		return heureDeutReservation;
	}


	public void setHeureDeutReservation(Date heureDeutReservation) {
		this.heureDeutReservation = heureDeutReservation;
	}



	public Date getDateFinReservation() {
		return dateFinReservation;
	}


	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
	}

	public Date getHeureFinReservation() {
		return heureFinReservation;
	}


	public void setHeureFinReservation(Date heureFinReservation) {
		this.heureFinReservation = heureFinReservation;
	}



	public Date getDateReservation() {
		return dateReservation;
	}



	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}



	public Integer getNbrePerson() {
		return nbrePerson;
	}



	public void setNbrePerson(Integer nbrePerson) {
		this.nbrePerson = nbrePerson;
	}



	public Boolean getIsMaterielReserve() {
		return isMaterielReserve;
	}



	public void setIsMaterielReserve(Boolean isMaterielReserve) {
		this.isMaterielReserve = isMaterielReserve;
	}

	
	
}
