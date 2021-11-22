package com.qa.demo.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Boat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boatId;
	
	@Column(name = "boat_type", nullable = false)
	private String boatType;
	
	@Column(name = "boat_company", nullable = false)
	private String boatCompany;
	
	@Column(name = "avg_crew_weight", nullable = false)
	private int averageCrewWeight;
	
	@Column(name = "rigger_material", nullable = false)
	private String riggerMaterial;
	
	@Column(name = "wing_rigger", nullable = false)
	private boolean wingRigger;
	
	@ManyToOne
	private BoatClub boatClub;

	public Boat() {
		super();
	}

	public Boat(long boatId, String boatType, String boatCompany, int averageCrewWeight, String riggerMaterial,
			boolean wingRigger, BoatClub boatClub) {
		super();
		this.boatId = boatId;
		this.boatType = boatType;
		this.boatCompany = boatCompany;
		this.averageCrewWeight = averageCrewWeight;
		this.riggerMaterial = riggerMaterial;
		this.wingRigger = wingRigger;
		this.boatClub = boatClub;
	}

	public Boat(String boatType, String boatCompany, int averageCrewWeight, String riggerMaterial, boolean wingRigger,
			BoatClub boatClub) {
		super();
		this.boatType = boatType;
		this.boatCompany = boatCompany;
		this.averageCrewWeight = averageCrewWeight;
		this.riggerMaterial = riggerMaterial;
		this.wingRigger = wingRigger;
		this.boatClub = boatClub;
	}

	public long getBoatId() {
		return boatId;
	}

	public void setBoatId(long boatId) {
		this.boatId = boatId;
	}

	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public String getBoatCompany() {
		return boatCompany;
	}

	public void setBoatCompany(String boatCompany) {
		this.boatCompany = boatCompany;
	}

	public int getAverageCrewWeight() {
		return averageCrewWeight;
	}

	public void setAverageCrewWeight(int averageCrewWeight) {
		this.averageCrewWeight = averageCrewWeight;
	}

	public String getRiggerMaterial() {
		return riggerMaterial;
	}

	public void setRiggerMaterial(String riggerMaterial) {
		this.riggerMaterial = riggerMaterial;
	}

	public boolean isWingRigger() {
		return wingRigger;
	}

	public void setWingRigger(boolean wingRigger) {
		this.wingRigger = wingRigger;
	}

	public BoatClub getBoatClub() {
		return boatClub;
	}

	public void setBoatClub(BoatClub boatClub) {
		this.boatClub = boatClub;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averageCrewWeight, boatClub, boatCompany, boatId, boatType, riggerMaterial, wingRigger);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boat other = (Boat) obj;
		return averageCrewWeight == other.averageCrewWeight && Objects.equals(boatClub, other.boatClub)
				&& Objects.equals(boatCompany, other.boatCompany) && boatId == other.boatId
				&& Objects.equals(boatType, other.boatType) && Objects.equals(riggerMaterial, other.riggerMaterial)
				&& wingRigger == other.wingRigger;
	}
	
	
}
