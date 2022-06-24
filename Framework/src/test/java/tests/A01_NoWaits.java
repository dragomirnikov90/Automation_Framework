package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A01_NoWaits {

	private WebDriver driver;
	private String baseURL;

	@Test
	public void searchUsingGoogle() {
		WebElement acceptButton = driver.findElement(By.xpath("//*[contains(text(),'Приемам')]/parent::button"));
		acceptButton.click();
		WebElement searchInputTextElement = driver.findElement(By.name("q"));
		searchInputTextElement.sendKeys("Quality Assurance");
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		baseURL = "https://www.google.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.get(baseURL); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
