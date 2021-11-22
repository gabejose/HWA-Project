package com.qa.demo.readTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadBoatClubTest {

	private WebDriver driver;
	
	public String URL = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Read/readBoatClubs.html";
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if title of page is "Read Boat Clubs"
	@Test
	public void titleTest() {
		String title = "Read Boat Clubs";
		driver.get(URL);
		
		Assertions.assertEquals(title, driver.getTitle());
	}
	
	// Check if header of page is "Let's check out some Boat Clubs!"
	// Also checks if header is correct tag <h1>
	@Test
	public void headerTest() {
		String headerTest = "Let's check out some Boat Clubs!";
		String tagTest = "h1";
		driver.get(URL);
		
		WebElement header = driver.findElement(By.xpath("/html/body/h1"));
		
		Assertions.assertEquals(headerTest, header.getText());
		System.out.println(header.getTagName());
		Assertions.assertEquals(tagTest, header.getTagName());
	}
	
	// Check if you can return to the Home - Boat Clubs page
	@Test
	public void returnHomeTest() {
		driver.get(URL);
		
		WebElement gif = driver.findElement(By.xpath("/html/body/nav/div/a"));
		
		gif.click();
		
		Assertions.assertNotEquals(URL, driver.getCurrentUrl());
	}
	
	// Check if the button to clear the table of boat clubs says "Clear table"
	@Test
	public void clearTableTest() {
		String buttonText = "Clear table";
		String tagTest = "button";
		driver.get(URL);
		
		WebElement button = driver.findElement(By.xpath("/html/body/button[3]"));
		
		System.out.println(button.getTagName());
		Assertions.assertEquals(buttonText, button.getText());
		Assertions.assertEquals(tagTest, button.getTagName());
		
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
