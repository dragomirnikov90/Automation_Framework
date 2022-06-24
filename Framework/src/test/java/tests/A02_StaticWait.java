package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A02_StaticWait {

	private WebDriver driver;
	private String baseURL;

	@Test
	public void staticWait() {

		// Static Wait
		try {
			System.out.println("Before Pause");
			Thread.sleep(5000);
			System.out.println("After Pause");
		} catch (InterruptedException ie) {
		}

		WebElement fullName = driver.findElement(By.id("userName"));
		fullName.sendKeys("Tester Testerov");
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("testertesterov@mail.com");
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.get(baseURL + "text-box"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
