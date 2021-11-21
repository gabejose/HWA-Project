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
import com.qa.demo.domain.BoatClub;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BoatClubControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createBoatClubTest() throws Exception {
		BoatClub input = new BoatClub("London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		String inputAsJSON = this.mapper.writeValueAsString(input);
		RequestBuilder request = post("/boatclub/create").contentType(MediaType.APPLICATION_JSON).content(inputAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		BoatClub inputSaved = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		String inputSavedAsJSON = this.mapper.writeValueAsString(inputSaved);
		
		ResultMatcher checkBody = content().json(inputSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void getAllBoatClubsTest() throws Exception {
		BoatClub club = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		String clubAsJSON = this.mapper.writeValueAsString(List.of(club));
		RequestBuilder request = get("/boatclub/getAll").contentType(MediaType.APPLICATION_JSON).content(clubAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(clubAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void getBoatClubByIdTest() throws Exception {
		BoatClub club = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		String clubAsJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = get("/boatclub/getById/1").contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isOk();
		
		ResultMatcher checkBody = content().json(clubAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void updateBoatClubTest() throws Exception {
		BoatClub club = new BoatClub(1L, "Thames Rowing Club", "69 Someroad Putney Embankment SW3 1RX", "TRC", "Ozgur", "Kafali");
		String clubAsJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = put("/boatclub/update/1").contentType(MediaType.APPLICATION_JSON).content(clubAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		ResultMatcher checkBody = content().json(clubAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void deleteBoatClubTest() throws Exception {
		RequestBuilder request = delete("/boatclub/delete/1");
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(request).andExpect(checkStatus);
	}
}
