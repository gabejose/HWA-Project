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
	
	@Column(name = "is_wing_rigger", nullable = false)
	private boolean isWingRigger;
	
	@ManyToOne
	private BoatClub boatClub;
	
	public Boat() {
		super();
	}

	public Boat(long boatId, String boatType, String boatCompany, int averageCrewWeight, String riggerMaterial,
			boolean isWingRigger) {
		super();
		this.boatId = boatId;
		this.boatType = boatType;
		this.boatCompany = boatCompany;
		this.averageCrewWeight = averageCrewWeight;
		this.riggerMaterial = riggerMaterial;
		this.isWingRigger = isWingRigger;
	}

	public Boat(String boatType, String boatCompany, int averageCrewWeight, String riggerMaterial,
			boolean isWingRigger) {
		super();
		this.boatType = boatType;
		this.boatCompany = boatCompany;
		this.averageCrewWeight = averageCrewWeight;
		this.riggerMaterial = riggerMaterial;
		this.isWingRigger = isWingRigger;
	}
	
	public Boat(long boatId, String boatType, String boatCompany, int averageCrewWeight, String riggerMaterial,
			boolean isWingRigger, BoatClub boatClub) {
		super();
		this.boatId = boatId;
		this.boatType = boatType;
		this.boatCompany = boatCompany;
		this.averageCrewWeight = averageCrewWeight;
		this.riggerMaterial = riggerMaterial;
		this.isWingRigger = isWingRigger;
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
		return isWingRigger;
	}

	public void setWingRigger(boolean isWingRigger) {
		this.isWingRigger = isWingRigger;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averageCrewWeight, boatCompany, boatId, boatType, isWingRigger, riggerMaterial);
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
		return averageCrewWeight == other.averageCrewWeight && Objects.equals(boatCompany, other.boatCompany)
				&& boatId == other.boatId && Objects.equals(boatType, other.boatType)
				&& isWingRigger == other.isWingRigger && Objects.equals(riggerMaterial, other.riggerMaterial);
	}
}
