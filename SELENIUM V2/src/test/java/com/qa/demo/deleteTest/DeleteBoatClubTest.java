package com.qa.demo.deleteTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteBoatClubTest {

	private WebDriver driver;
	
	public String URL = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Delete/deleteBoatClub.html";
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check title is "Delete a boat club"
	@Test
	public void titleTest() {
		
	}
	
	// Check if h1 and h4 tags and text are correct
	// h1 tag should say "Let's delete a boat club"
	// h4 tag should say "Enter the ID of the boat club you wish to delete:"
	@Test
	public void tagsTest() {
		
	}
	
	// Check if you can return to the Home - Boat Clubs page
	@Test
	public void returnHomeTest() {
		
	}
	
	// Check if button to delete a boat club says "Delete"
	// Tag should also be "button"
	@Test
	public void deleteBtnTest() {
		
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
