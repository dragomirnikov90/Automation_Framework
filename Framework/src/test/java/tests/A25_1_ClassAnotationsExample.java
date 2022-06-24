package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import configuration.Configuration;
import configuration.MainMethods;
import pom.A25_1;

public class A25_1_ClassAnotationsExample {

	private WebDriver driver; // Declare a WebDriver.
	private MainMethods mainMethods; // Declare a MainMethods.
	private Configuration config; // Declare a Configuration.
	private A25_1 page; // Declare a page object model.
	private String baseURL;
	private String url;
	
	// Test Method 1
	@Test
	public void testMethod1() {
		mainMethods.navigateURL(url, page.fullNameInputTextElement);
	} 
	
	// Test Method 2
	@Test
	public void testMethod2() {
		driver.get("https://google.com");
	} 

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods
		config = new Configuration(); // Declare a constructor for Configuration.
		page = new A25_1(driver); // Declare a constructor for POM.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "text-box";
		driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
		driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}