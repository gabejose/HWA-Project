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

import com.qa.demo.domain.Boat;
import com.qa.demo.domain.BoatClub;
import com.qa.demo.repo.BoatRepo;

@RunWith(MockitoJUnitRunner.class)
public class BoatServiceUnitTest {

	@InjectMocks
	private BoatService service;
	
	@Mock
	private BoatRepo repo;
	
	@Mock
	private BoatClub club;
	
	@Test
	public void createBoatTest() {
		Boat input = new Boat("8+", "Empacher", 95, "Carbon", true, club);
		Boat output = new Boat(1L, "8+", "Empacher", 95, "Carbon", true, club);
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.createBoat(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	@Test
	public void getAllBoatsTest() {
		List<Boat> output = new ArrayList<>();
		output.add(new Boat("8+", "Empacher", 95, "Carbon", true, club));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAllBoats());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getBoatByIdTest() {
		long searchId = 1L;
		Boat output = new Boat(1L, "8+", "Empacher", 95, "Carbon", true, club);
		
		Mockito.when(this.repo.findById(searchId)).thenReturn(Optional.of(output));
		
		assertEquals(output, this.service.getBoatById(searchId));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(searchId);
	}
	
	@Test
	public void updateBoatTest() {
		long newId = 1L;
		Boat old = new Boat(1L, "8+", "Empacher", 95, "Carbon", true, club);
		Boat updated = new Boat(1L, "2-", "Filippi", 72, "Aluminium", false, club);
		
		Mockito.when(this.repo.findById(newId)).thenReturn(Optional.of(old));
		Mockito.when(this.repo.saveAndFlush(old)).thenReturn(updated);
		
		assertEquals(updated, this.service.updateBoat(newId, updated));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(newId);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(old);
	}
	
	@Test
	public void deleteBoatTest() {
		long deleteId = 1L;
		boolean deletedCheck = true;
		
		Mockito.when(this.repo.existsById(deleteId)).thenReturn(!deletedCheck);
		
		assertEquals(deletedCheck, this.service.deleteBoat(deleteId));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(deleteId);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(deleteId);
	}
}
