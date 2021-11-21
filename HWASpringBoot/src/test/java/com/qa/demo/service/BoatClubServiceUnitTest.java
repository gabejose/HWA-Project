package com.qa.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.demo.domain.BoatClub;
import com.qa.demo.repo.BoatClubRepo;

@RunWith(MockitoJUnitRunner.class)
public class BoatClubServiceUnitTest {

	@InjectMocks
	private BoatClubService service;
	
	@Mock
	private BoatClubRepo repo;
	
	@Test
	public void createBoatClubTest() {
		BoatClub input = new BoatClub("London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		BoatClub output = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.createBoatClub(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	@Test
	public void getAllClubsTest() {
		List<BoatClub> output = new ArrayList<>();
		output.add(new BoatClub("London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAllClubs());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getBoatClubByIdTest() {
		long searchId = 1L;
		BoatClub output = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		
		Mockito.when(this.repo.findById(searchId)).thenReturn(Optional.of(output));
		
		assertEquals(output, this.service.getBoatClubById(searchId));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(searchId);
	}
	
	@Test
	public void updateBoatClubTest() {
		long newId = 1L;
		BoatClub old = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		BoatClub updated = new BoatClub(1L, "Thames Rowing Club", "69 Someroad Putney Embankment SW3 1RX", "TRC", "Ozgur", "Kafali");
		
		Mockito.when(this.repo.findById(newId)).thenReturn(Optional.of(old));
		Mockito.when(this.repo.saveAndFlush(old)).thenReturn(updated);
		
		assertEquals(updated, this.service.updateBoatClub(newId, updated));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(newId);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(old);
	}
	
	@Test
	public void deleteBoatClubTest() {
		long deleteId = 1L;
		boolean deletedCheck = true;
		
		Mockito.when(this.repo.existsById(deleteId)).thenReturn(!deletedCheck);
		
		assertEquals(deletedCheck, this.service.deleteBoatClub(deleteId));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(deleteId);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(deleteId);
	}
}
