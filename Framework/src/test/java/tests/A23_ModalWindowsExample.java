package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import configuration.Configuration;
import configuration.MainMethods;
import pom.A23;

public class A23_ModalWindowsExample {

	private WebDriver driver; // Declare a WebDriver.
	private MainMethods mainMethods; // Declare a MainMethods.
	private Configuration config; // Declare a Configuration.
	private A23 page; // Declare a page object model.
	private String baseURL;
	private String url;
	
	@Test
	public void modalWindowsExample() {
		mainMethods.navigateURL(url, page.smallModalButton); // Navigate to the URL address.
		mainMethods.clickMethod(page.smallModalButton, page.smallModalWindowTextContent); // Click on the "Small modal" button.
		System.out.println("The copied text from thye small Modal window is: "+mainMethods.getText(page.smallModalWindowTextContent));
		mainMethods.clickMethod(page.closeButton1, page.largeModalButton);
		mainMethods.clickMethod(page.largeModalButton, page.largeModalWindowTextContent);
		System.out.println("The copied text from thye large Modal window is: "+mainMethods.getText(page.largeModalWindowTextContent));	
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods
		config = new Configuration(); // Declare a constructor for Configuration.
		page = new A23(driver); // Declare a constructor for POM..
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "modal-dialogs";
		driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
		driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
