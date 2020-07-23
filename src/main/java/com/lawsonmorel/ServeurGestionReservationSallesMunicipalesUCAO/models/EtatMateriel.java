package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etatMateriel")
public class EtatMateriel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private EMaterielEtat name;

	public EtatMateriel() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EMaterielEtat getName() {
		return name;
	}

	public void setName(EMaterielEtat name) {
		this.name = name;
	}

}
