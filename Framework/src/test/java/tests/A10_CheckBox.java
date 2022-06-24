package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A10_CheckBox {

	private WebDriver driver; // Declare a WebDriver.

	String baseURL;

	@Test
	public void clickOnCheckBox() {
		WebElement checkBox = driver.findElement(By.xpath("//span[@class='rct-checkbox']/*[local-name() = 'svg']"));
		checkBox.click();
	}
	

	@BeforeClass
	public void setUp() {
		driver  = new ChromeDriver(); // Create a new instance of Chrome driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(baseURL + "checkbox"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
