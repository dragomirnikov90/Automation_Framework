package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A12_ClickOnHyperlinks {

	private WebDriver driver; // Declare a WebDriver.
	private String baseURL;

	// Click on the regular hyperlink.
	@Test
	public void clickOnSimpleHyperlink() {
		WebElement hyperlink = driver.findElement(By.xpath("//*[@id='simpleLink']"));
		hyperlink.click();
	}

	// Click on the dynamic hyperlink.
	@Test
	public void clickOnDynamicHyperlink() {
		WebElement hyperlink = driver.findElement(By.xpath("//*[@id='dynamicLink']"));
		hyperlink.click();
	}
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(baseURL + "links"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
