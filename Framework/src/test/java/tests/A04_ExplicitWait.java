package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class A04_ExplicitWait {

	private WebDriver driver;
	private String baseURL;

	@Test
	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, 40); // Declare the explicit wait method.
		WebElement fillWithUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		fillWithUsername.sendKeys("Tester Testerov");
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
		email.sendKeys("tester@test.bg");
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.get(baseURL + "text-box"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
