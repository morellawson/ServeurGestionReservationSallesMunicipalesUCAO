package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 150)
	private String etat;
	
	@Column(name="date_facture")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateFacture;
	
	private Double prixTotalReserv;

	public Facture() {
		
	}

	public Facture(String etat, Date dateFacture, Double prixTotalReserv) {
		this.etat = etat;
		this.dateFacture = dateFacture;
		this.prixTotalReserv = prixTotalReserv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public Double getPrixTotalReserv() {
		return prixTotalReserv;
	}

	public void setPrixTotalReserv(Double prixTotalReserv) {
		this.prixTotalReserv = prixTotalReserv;
	}


}
