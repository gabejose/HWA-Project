package com.qa.demo.createTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateBoatTest {

	private WebDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if you can return to the index page
	// Title of result page should be "Index page"
	@Test
	public void indexReturnTest() {
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Create/createBoat.html";
		driver.get(url);
		WebElement link = driver.findElement(By.xpath("/html/body/nav/div/a"));
		String resultTitle = "Index page";
		
		link.click();
		
		Assertions.assertEquals(resultTitle, driver.getTitle());
	}
	
	// Check if you can return to the "Home - Boats" page
	// Title of result page should be "Home - Boats"
	@Test
	public void returnHomeTest() {
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Create/createBoat.html";
		driver.get(url);
		WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[1]/a"));
		String resultTitle = "Home - Boats";
		
		homeLink.click();
		
		Assertions.assertEquals(resultTitle, driver.getTitle());
	}
	
	// Check if you can go to the Delete Boat page
	// Title of result page should be "Delete a boat"
	@Test
	public void goToDeleteTest() {
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Create/createBoat.html";
		driver.get(url);
		WebElement deleteLink = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[5]/a"));
		String resultTitle = "Delete a boat";
		
		deleteLink.click();
		
		Assertions.assertEquals(resultTitle, driver.getTitle());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
