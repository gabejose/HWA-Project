package com.qa.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Boat;
import com.qa.demo.service.BoatService;

@CrossOrigin
@RestController
@RequestMapping("/boat")
public class BoatController {

	private BoatService service;

	// Constructor Injection
	public BoatController(BoatService service) {
		super();
		this.service = service;
	}
	
	// Create
	@PostMapping("/createBoat")
	public ResponseEntity<Boat> createBoat(@RequestBody Boat boat) {
		return new ResponseEntity<Boat>(this.service.createBoat(boat), HttpStatus.CREATED);
	}
	
	// Read
	@GetMapping("/getAllBoats")
	public ResponseEntity<List<Boat>> getAllBoats() {
		return new ResponseEntity<List<Boat>>(this.service.getAllBoats(), HttpStatus.ACCEPTED);
	}
	
	// Read by ID
	@GetMapping("/getBoatById/{id}")
	public ResponseEntity<Boat> getBoatById(@PathVariable long id) {
		return new ResponseEntity<Boat>(this.service.getBoatById(id), HttpStatus.OK);
	}
	
	// Update
	@GetMapping("/updateBoat/{id}")
	public ResponseEntity<Boat> updateBoat(@PathVariable long id, @RequestBody Boat boat) {
		return new ResponseEntity<Boat>(this.service.updateBoat(id, boat), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/deleteBoat/{id}")
	public ResponseEntity<Boat> deleteBoat(@PathVariable long id) {
		return this.service.deleteBoat(id) ? new ResponseEntity<Boat>(HttpStatus.NO_CONTENT) : new ResponseEntity<Boat>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
