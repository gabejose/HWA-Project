package com.qa.demo.updateTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateBoatTest {

	private WebDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if title of the page is "Update Boats"
	@Test
	public void testTitle() {
		String testTitle = "Update Boats";
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Update/updateBoat.html";
		
		driver.get(url);
		
		Assertions.assertEquals(testTitle, driver.getTitle());
	}
	
	// Check if header is "Let's update a boat!"
	@Test
	public void headerTest() {
		String testHeader = "Let's update a boat!";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/Update/updateBoat.html");
		WebElement header = driver.findElement(By.xpath("/html/body/h1"));
		
		Assertions.assertEquals(testHeader, header.getText());
	}
	
	// Check if you can go back to the Create Boat page
	@Test
	public void createLinkTest() {
		String resultTitle = "Create a Boat";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/Update/updateBoat.html");
		WebElement createLink = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a"));
		
		createLink.click();
		
		Assertions.assertEquals(resultTitle, driver.getTitle());
	}
	
	// Check if the button text to reset the form is "Reset"
	@Test
	public void resetBtnTest() {
		String buttonName = "Reset";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/Update/updateBoat.html");
		WebElement button = driver.findElement(By.xpath("/html/body/form/button[1]"));
		
		Assertions.assertEquals(buttonName, button.getText());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
