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

public class DeleteBoatTest {

	private WebDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		// Our webdriver is being specified as a chrome driver
		this.driver = new ChromeDriver(); 
		 // Create a new browser window with these measurements (measured in pixels)
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	// Check if title of page is "Delete a boat"
	@Test
	public void titleTest() {
		String testTitle = "Delete a boat";
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Delete/deleteBoat.html";
		
		this.driver.get(url);
		
		Assertions.assertEquals(testTitle, driver.getTitle());
	}
	
	// Check if h4 tag contains text "Let's delete a boat...by smashing it"
	@Test
	public void h4TextTest() {
		String text = "Enter the ID of the boat you wish to delete:";
		driver.get("http://127.0.0.1:5500/HWAFrontEnd/HTML/Delete/deleteBoat.html");
		
		WebElement h4 = driver.findElement(By.xpath("/html/body/h4"));
		
		Assertions.assertEquals(text, h4.getText());
	}
	
	// Check if you can return to the index page
	@Test
	public void indexReturnTest() {
		String indexTitle = "Index page";
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Delete/deleteBoat.html";
		driver.get(url);
		
		WebElement gif = driver.findElement(By.xpath("/html/body/nav/div/a"));
		
		gif.click();
		
		Assertions.assertEquals(indexTitle, driver.getTitle());
	}
	
	// Check if text on the button says "Delete"
	@Test
	public void deleteBtnTextTest() {
		String buttonText = "Delete";
		String url = "http://127.0.0.1:5500/HWAFrontEnd/HTML/Delete/deleteBoat.html";
		driver.get(url);
		
		WebElement button = driver.findElement(By.xpath("/html/body/form/button"));
		Assertions.assertEquals(buttonText, button.getText());
	}
	
	@AfterEach
	public void tearDown() {
		driver.close();
	}
}
