package com.qa.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.domain.Boat;
import com.qa.demo.domain.BoatClub;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BoatControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createBoatTest() throws Exception {
		BoatClub club = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		Boat boat = new Boat("8+", "Empacher", 95, "Carbon", true, club);
		
		String boatAsJSON = this.mapper.writeValueAsString(boat);
		RequestBuilder request = post("/boat/createBoat").contentType(MediaType.APPLICATION_JSON).content(boatAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Boat boatSaved = new Boat(1L, "8+", "Empacher", 95, "Carbon", true, club);
		String boatSavedAsJSON = this.mapper.writeValueAsString(boatSaved);
		
		ResultMatcher checkBody = content().json(boatSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void getAllBoatsTest() throws Exception {
		BoatClub club = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		Boat boat = new Boat(1L, "8+", "Empacher", 95, "Carbon", true, club);
		String boatAsJSON = this.mapper.writeValueAsString(List.of(boat));
		RequestBuilder request = get("/boat/getAllBoats").contentType(MediaType.APPLICATION_JSON).content(boatAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(boatAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void getBoatByIdTest() throws Exception {
		BoatClub club = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		Boat boat = new Boat(1L, "8+", "Empacher", 95, "Carbon", true, club);
		String boatAsJSON = this.mapper.writeValueAsString(boat);
		RequestBuilder request = get("/boat/getBoatById/1").contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isOk();
		
		ResultMatcher checkBody = content().json(boatAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void updateBoatTest() throws Exception {
		BoatClub club = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		Boat boat = new Boat(1L, "4x-", "Filippi", 82, "Aluminium", true, club);
		String boatAsJSON = this.mapper.writeValueAsString(boat);
		RequestBuilder request = put("/boat/updateBoat/1").contentType(MediaType.APPLICATION_JSON).content(boatAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(boatAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void deleteBoatTest() throws Exception {
		RequestBuilder request = delete("/boat/deleteBoat/1");
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(request).andExpect(checkStatus);
	}
}
