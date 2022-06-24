package tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import configuration.WaitTypes;

public class A07_ExplicitWaitOutside {

	private WebDriver driver;
	private WaitTypes wait;
	private String baseURL;

	@Test
	public void explicitWait() {
		WebElement fillWithUsername = wait.waitVisibilityOfElementLocatedBy(By.id("userName"), 40);
		fillWithUsername.sendKeys("Tester Testerov");
		WebElement email = wait.waitVisibilityOfElementLocatedBy(By.id("userEmail"), 40);
		email.sendKeys("tester@test.bg");
		wait.waitElementToBeClickableBy(By.id("submit"), 40);
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		wait = new WaitTypes(driver); // We need to create a constructor.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.get(baseURL + "text-box"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
