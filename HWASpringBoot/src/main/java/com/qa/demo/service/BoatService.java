package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.domain.Boat;
import com.qa.demo.repo.BoatRepo;

@Service
public class BoatService {

	private BoatRepo repo;

	public BoatService(BoatRepo repo) {
		super();
		this.repo = repo;
	}
	
	// Create
	// @param The boat we want to create
	// @return the newly created boat
	public Boat createBoat(Boat boat) {
		return this.repo.saveAndFlush(boat);
	}
	
	// Read all
	// @return The list of boats currently in the system
	public List<Boat> getAllBoats() {
		return this.repo.findAll();
	}
	
	// Read by Id
	// @param The id of the boat we want to read
	// @return the boat with that id
	public Boat getBoatById(long id) {
		return this.repo.findById(id).get();
	}
	
	// Update
	// @param The id of the boat we want to update
	// @param The boat with the new details
	// @return The newly updated boat
	public Boat updateBoat(long id, Boat boat) {
		Boat existing = this.repo.findById(id).get();
		
		existing.setBoatType(boat.getBoatType());
		existing.setBoatCompany(boat.getBoatCompany());
		existing.setAverageCrewWeight(boat.getAverageCrewWeight());
		existing.setRiggerMaterial(boat.getRiggerMaterial());
		existing.setWingRigger(boat.isWingRigger());
		
		return this.repo.saveAndFlush(existing);
	}
	
	// Delete
	// @param The id of the boat we want to delete
	// @return True/False depending on if the boat was deleted or not
	public boolean deleteBoat(long id) {
		this.repo.deleteById(id);
		// Checks if ID exists in database
		return !this.repo.existsById(id);
	}
}
