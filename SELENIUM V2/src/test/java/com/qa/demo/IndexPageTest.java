package com.qa.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndexPageTest {

	private WebDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Test for checking if title of boat home page is "Home - Boats"
	@Test
	public void indexTitleTest() {
		String titleTest = "Index page";
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/index.html";
		
		this.driver.get(url);
		
		System.out.println(driver.getTitle());
		Assertions.assertEquals(titleTest, driver.getTitle());
	}
	
	// Test for checking if header of index page is "Welcome to the index page"
	@Test
	public void headerTest() {
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/index.html");
		String headerTest = "Welcome to the index page";
		WebElement header = driver.findElement(By.xpath("/html/body/h1"));
		
		Assertions.assertEquals(headerTest, header.getText());
	}
	
	// Test for checking that the boats link goes to the Home - Boats page
	// Title should be "Home - Boats"
	@Test
	public void boatLinkTest() {
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/index.html";
		driver.get(url);
		WebElement boatLink = driver.findElement(By.xpath("/html/body/ul/li[1]/a"));
		String title = "Home - Boats";
		
		boatLink.click();
		
		Assertions.assertEquals(title, driver.getTitle());
	}
	
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
