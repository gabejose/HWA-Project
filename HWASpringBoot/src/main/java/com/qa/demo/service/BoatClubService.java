package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.domain.BoatClub;
import com.qa.demo.repo.BoatClubRepo;

@Service
public class BoatClubService {

	private BoatClubRepo repo;

	public BoatClubService(BoatClubRepo repo) {
		super();
		this.repo = repo;
	}
	
	// Create
	// @param The boat club we want to add
	// @return the newly added boat club
	public BoatClub createBoatClub(BoatClub club) {
		return this.repo.saveAndFlush(club);
	}
	
	// Read All
	// @return All the boat clubs currently in the system
	public List<BoatClub> getAllClubs() {
		return this.repo.findAll();
	}
	
	// Read one
	// @param The id of the boat club
	// @return the boat club of that id
	public BoatClub getBoatClubById(long id) {
		return this.repo.findById(id).get();
	}
	
	// Update
	// @param id of the boat club to update
	// @param the new details of the boat club
	// @return the updated boat club
	public BoatClub updateBoatClub(long id, BoatClub newClub) {
		BoatClub existing = this.repo.findById(id).get();
		// Set fields for newClub that isn't ID
		existing.setBoatClubName(newClub.getBoatClubName());
		existing.setAddress(newClub.getAddress());
		existing.setBoatClubCode(newClub.getBoatClubCode());
		existing.setHeadCoachFirstName(newClub.getHeadCoachFirstName());
		existing.setHeadCoachSurname(newClub.getHeadCoachSurname());
		return this.repo.saveAndFlush(existing);
	}
	
	// Delete
	// @param The id of the boat club we want to delete
	// @return checking if the boat club has been deleted
	public boolean deleteBoatClub(long id) {
		this.repo.deleteById(id);
		// Check if ID exists in database (True or False)
		return !this.repo.existsById(id);
	}
}
