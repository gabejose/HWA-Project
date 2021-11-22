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

public class ReadBoatTest {

	private WebDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if the title is "Read Boats"
	@Test
	public void checkTitleTest() {
		String checkTitle = "Read Boats";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/Read/readBoats.html");
		Assertions.assertEquals(checkTitle, driver.getTitle());
	}
	
	// Check if the header is "Let's check out some boats!"
	@Test
	public void checkHeaderTest() {
		String checkHeader = "Let's check out some boats!";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/Read/readBoats.html");
		WebElement header = driver.findElement(By.xpath("/html/body/h1"));
		
		Assertions.assertEquals(checkHeader, header.getText());
	}
	
	// Check if you can return to the index page
	// Title of result page is "Index page"
	@Test
	public void returnIndexTest() {
		String checkIndex = "Index page";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/Read/readBoats.html");
		WebElement indexLink = driver.findElement(By.xpath("/html/body/nav/div/a"));
		
		indexLink.click();
		
		Assertions.assertEquals(checkIndex, driver.getTitle());
	}
	
	
	// Check if you can go to the Update Boat page
	// Title should be "Update Boats"
	public void updateLinkTest() {
		String checkTitle = "Update Boats";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/Read/readBoats.html");
		WebElement updateLink = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[4]/a"));
		
		updateLink.click();
		
		Assertions.assertEquals(checkTitle, driver.getTitle());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
