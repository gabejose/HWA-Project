package com.qa.demo.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BoatClub {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boatClubId;
	
	@Column(name = "boat_club_name", nullable = false)
	private String boatClubName;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(unique = true, nullable = false)
	private String boatClubCode;
	
	@Column(name = "head_coach_first_name", nullable = true)
	private String headCoachFirstName;
	
	@Column(name = "head_coach_surname", nullable = true)
	private String headCoachSurname;

	public BoatClub() {
		super();
	}

	public BoatClub(long boatClubId, String boatClubName, String address, String boatClubCode,
			String headCoachFirstName, String headCoachSurname) {
		super();
		this.boatClubId = boatClubId;
		this.boatClubName = boatClubName;
		this.address = address;
		this.boatClubCode = boatClubCode;
		this.headCoachFirstName = headCoachFirstName;
		this.headCoachSurname = headCoachSurname;
	}

	public BoatClub(String boatClubName, String address, String boatClubCode, String headCoachFirstName,
			String headCoachSurname) {
		super();
		this.boatClubName = boatClubName;
		this.address = address;
		this.boatClubCode = boatClubCode;
		this.headCoachFirstName = headCoachFirstName;
		this.headCoachSurname = headCoachSurname;
	}

	public long getBoatClubId() {
		return boatClubId;
	}

	public void setBoatClubId(long boatClubId) {
		this.boatClubId = boatClubId;
	}

	public String getBoatClubName() {
		return boatClubName;
	}

	public void setBoatClubName(String boatClubName) {
		this.boatClubName = boatClubName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBoatClubCode() {
		return boatClubCode;
	}

	public void setBoatClubCode(String boatClubCode) {
		this.boatClubCode = boatClubCode;
	}

	public String getHeadCoachFirstName() {
		return headCoachFirstName;
	}

	public void setHeadCoachFirstName(String headCoachFirstName) {
		this.headCoachFirstName = headCoachFirstName;
	}

	public String getHeadCoachSurname() {
		return headCoachSurname;
	}

	public void setHeadCoachSurname(String headCoachSurname) {
		this.headCoachSurname = headCoachSurname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, boatClubCode, boatClubId, boatClubName, headCoachFirstName, headCoachSurname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoatClub other = (BoatClub) obj;
		return Objects.equals(address, other.address) && Objects.equals(boatClubCode, other.boatClubCode)
				&& boatClubId == other.boatClubId && Objects.equals(boatClubName, other.boatClubName)
				&& Objects.equals(headCoachFirstName, other.headCoachFirstName)
				&& Objects.equals(headCoachSurname, other.headCoachSurname);
	}
}
