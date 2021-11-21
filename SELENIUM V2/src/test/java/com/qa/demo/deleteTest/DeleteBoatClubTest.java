package com.qa.demo.deleteTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		String title = "Delete a boat club";
		driver.get(URL);
		
		Assertions.assertEquals(title, driver.getTitle());
	}
	
	// Check if h1 and h4 tags and text are correct
	// h1 tag should say "Let's delete a boat club"
	// h4 tag should say "Enter the ID of the boat club you wish to delete:"
	@Test
	public void tagsTest() {
		String h1Test = "h1";
		String h4Test = "h4";
		String h1Content = "Let's delete a boat club!";
		String h4Content = "Enter the ID of the boat club you wish to delete:";
		
		driver.get(URL);
		
		WebElement h1 = driver.findElement(By.xpath("/html/body/h1"));
		WebElement h4 = driver.findElement(By.xpath("/html/body/h4"));
		
		Assertions.assertEquals(h1Test, h1.getTagName());
		Assertions.assertEquals(h4Test, h4.getTagName());
		Assertions.assertEquals(h1Content, h1.getText());
		Assertions.assertEquals(h4Content, h4.getText());
		
	}
	
	// Check if you can return to the Home - Boat Clubs page
	@Test
	public void returnHomeTest() {
		driver.get(URL);
		
		WebElement home = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[1]/a"));
		
		home.click();
		
		Assertions.assertNotEquals(URL, driver.getCurrentUrl());
	}
	
	// Check if button to delete a boat club says "Delete"
	// Tag should also be "button"
	@Test
	public void deleteBtnTest() {
		String tagTest = "button";
		String buttonContent = "Delete";
		driver.get(URL);
		
		WebElement button = driver.findElement(By.xpath("/html/body/form/button"));
		
		Assertions.assertEquals(tagTest, button.getTagName());
		Assertions.assertEquals(buttonContent, button.getText());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
