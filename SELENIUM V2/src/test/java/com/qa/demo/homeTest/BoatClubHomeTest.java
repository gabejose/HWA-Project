package com.qa.demo.homeTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoatClubHomeTest {

	private WebDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if title of page is "Home - Boat Clubs"
	@Test
	public void titleTest() {
		String testTitle = "Home - Boat Clubs";
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/boatclubs.html";
		
		this.driver.get(url);
		
		Assertions.assertEquals(testTitle, driver.getTitle());
	}
	
	// Check if header of page is "Welcome to the Boat Clubs page!"
	@Test
	public void headerTest() {
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/boatclubs.html");
		WebElement header = driver.findElement(By.xpath("/html/body/h1"));
		String headerTest = "Welcome to the Boat Clubs page!";
		
		Assertions.assertEquals(headerTest, header.getText());
	}
	
	// Check if you can go to the Home - Boats page by clicking the link
	// Title should be "Home - Boats"
	@Test
	public void linkTest() {
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/boatclubs.html");
		WebElement link = driver.findElement(By.xpath("/html/body/h5/a"));
		String resultTitle = "Home - Boats";
		
		link.click();
		
		Assertions.assertEquals(resultTitle, driver.getTitle());
	}
	
	// Check if you can go to the Read Boats page by clicking the tab
	// Title of the result page should be "Read Boat Clubs"
	@Test
	public void readLinkTest() {
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/boatclubs.html");
		WebElement readLink = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[3]/a"));
		String resultTitle = "Read Boat Clubs";
		
		readLink.click();
		
		Assertions.assertEquals(resultTitle, driver.getTitle());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
