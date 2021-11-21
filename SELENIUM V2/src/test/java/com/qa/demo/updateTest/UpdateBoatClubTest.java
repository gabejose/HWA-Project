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

public class UpdateBoatClubTest {

	private WebDriver driver;
	
	public String URL = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Update/updateBoatClub.html";
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if title of page is "Update Boat Club"
	@Test
	public void titleTest() {
		String titleTest = "Update Boat Club";
		driver.get(URL);
		
		Assertions.assertEquals(titleTest, driver.getTitle());
	}
	
	// Check if text in h4 tags are correct (both text and tags)
	// First h4 should say "Enter the ID of the club you wish to update"
	// Second h4 should say "Enter the new boat club details"
	@Test
	public void h4Test() {
		String tagTest = "h4";
		String firstH4Text = "Enter the ID of the club you wish to update:";
		String secondH4Text = "Enter the new boat club details:";
		driver.get(URL);
		
		WebElement h4One = driver.findElement(By.xpath("/html/body/h4[1]"));
		WebElement h4Two = driver.findElement(By.xpath("/html/body/h4[2]"));
		
		Assertions.assertEquals(tagTest, h4One.getTagName());
		Assertions.assertEquals(tagTest, h4Two.getTagName());
		Assertions.assertEquals(firstH4Text, h4One.getText());
		Assertions.assertEquals(secondH4Text, h4Two.getText());
		
	}
	
	// Check if you can return to the index page
	@Test
	public void returnToIndexTest() {
		driver.get(URL);
		
		WebElement gif = driver.findElement(By.xpath("/html/body/nav/div/a"));
		
		gif.click();
		
		Assertions.assertNotEquals(URL, driver.getCurrentUrl());
	}
	
	// Check if the button to update the boat club is correct (both tag and text)
	// Tag is "button"
	// Text is "Update"
	@Test
	public void updateBtnTest() {
		String tagTest = "button";
		String buttonText = "Update";
		driver.get(URL);
		
		WebElement button = driver.findElement(By.xpath("/html/body/form/button[2]"));
		
		Assertions.assertEquals(tagTest, button.getTagName());
		Assertions.assertEquals(buttonText, button.getText());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
