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

public class CreateBoatClubTest {

	private WebDriver driver;
	
	public String URL = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Create/createBoatClub.html";
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if title is "Create a Boat Club"
	@Test
	public void titleTest() {
		String title = "Create a Boat Club";
		driver.get(URL);
		
		Assertions.assertEquals(title, driver.getTitle());
	}
	
	// Check if the h4 text is "Enter the details of the boat club below:"
	@Test
	public void h4Test() {
		String text = "Enter the details of the boat club below:";
		driver.get(URL);
		
		WebElement h4 = driver.findElement(By.xpath("/html/body/h4"));
		
		Assertions.assertEquals(text, h4.getText());
	}
	
	// Check if you can return to the index page
	@Test
	public void returnToIndexTest() {
		driver.get(URL);
		
		WebElement gif = driver.findElement(By.xpath("/html/body/nav/div/a"));
		
		gif.click();
		
		Assertions.assertNotEquals(URL, driver.getCurrentUrl());
	}
	
	// Check if the button to reset the form is labelled "Reset"
	@Test
	public void resetBtnTest() {
		String buttonText = "Reset";
		driver.get(URL);
		
		WebElement button = driver.findElement(By.xpath("/html/body/form/button[1]"));
		
		Assertions.assertEquals(buttonText, button.getText());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
