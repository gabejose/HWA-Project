package com.qa.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
		BoatClub club = new BoatClub("London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		Boat boat = new Boat("8+", "Empacher", 95, "Carbon", true, club);
		
		String boatAsJSON = this.mapper.writeValueAsString(boat);
		RequestBuilder request = post("/boat/createBoat").contentType(MediaType.APPLICATION_JSON).content(boatAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Boat boatSaved = new Boat("8+", "Empacher", 95, "Carbon", true, club);
		String boatSavedAsJSON = this.mapper.writeValueAsString(boatSaved);
		
		ResultMatcher checkBody = content().json(boatSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
}
