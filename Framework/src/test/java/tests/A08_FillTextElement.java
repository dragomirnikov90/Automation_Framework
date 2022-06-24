package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A08_FillTextElement {

	private WebDriver driver;
	private String baseURL;

	@Test
	public void imputTextElementWithText() {
		WebElement fullName = driver.findElement(By.id("userName"));
		fullName.sendKeys("Tester Testerov");
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("testertesterov@mail.com");
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // Set Implicit Wait.
		driver.get(baseURL + "text-box"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
