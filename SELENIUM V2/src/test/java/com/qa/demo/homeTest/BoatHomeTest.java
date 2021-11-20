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

public class BoatHomeTest {

	private WebDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if title of page is "Home - Boats"
	@Test
	public void titleTest() {
		String testTitle = "Home - Boats";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/boats.html");
		
		Assertions.assertEquals(testTitle, driver.getTitle());
	}
	
	// Check if header of page is "Welcome to the Boats page!
	@Test
	public void headerTest() {
		String headerTest = "Welcome to the Boats page!";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/boats.html");
		WebElement header = driver.findElement(By.xpath("/html/body/h1"));
		
		Assertions.assertEquals(headerTest, header.getText());
	}
	
	// Check if you can return to the index page by clicking the GIF
	@Test
	public void returnToIndexTest() {
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/boats.html");
		WebElement gif = driver.findElement(By.xpath("/html/body/nav/div/a/img"));
		String title = "Index page";
		
		gif.click();
		
		Assertions.assertEquals(title, driver.getTitle());
	}
	
	// Check if you can go to the Home - Boat Clubs page
	@Test
	public void boatClubLinkTest() {
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/boats.html");
		WebElement link = driver.findElement(By.xpath("/html/body/h5/a"));
		String title = "Home - Boat Clubs";
		
		link.click();
		
		Assertions.assertEquals(title, driver.getTitle());
	}
	
	// Check if you can go to the createBoat page
	@Test
	public void goCreateBoatTest() {
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/boats.html");
		WebElement createLink = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a"));
		String title = "Create a Boat";
		
		createLink.click();
		
		Assertions.assertEquals(title, driver.getTitle());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
