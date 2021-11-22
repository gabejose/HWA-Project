package com.qa.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.BoatClub;
import com.qa.demo.service.BoatClubService;

@CrossOrigin
@RestController
@RequestMapping("/boatclub")
public class BoatClubController {

	private BoatClubService service;

	// Constructor Injection
	public BoatClubController(BoatClubService service) {
		super();
		this.service = service;
	}
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<BoatClub> createBoatClub(@RequestBody BoatClub club) {
		return new ResponseEntity<BoatClub>(this.service.createBoatClub(club), HttpStatus.CREATED);
	}
	
	// Read all
	@GetMapping("/getAll")
	public ResponseEntity<List<BoatClub>> readAllBoatClubs() {
		return new ResponseEntity<List<BoatClub>>(this.service.getAllClubs(), HttpStatus.ACCEPTED);
	}
	
	// Read by ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<BoatClub> getBoatClubById(@PathVariable long id) {
		return new ResponseEntity<BoatClub>(this.service.getBoatClubById(id), HttpStatus.OK);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<BoatClub> updateBoatClub(@PathVariable long id, @RequestBody BoatClub club) {
		return new ResponseEntity<BoatClub>(this.service.updateBoatClub(id, club), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BoatClub> removeBoatClub(@PathVariable long id) {
		return this.service.deleteBoatClub(id) ? new ResponseEntity<BoatClub>(HttpStatus.NO_CONTENT) : new ResponseEntity<BoatClub>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
