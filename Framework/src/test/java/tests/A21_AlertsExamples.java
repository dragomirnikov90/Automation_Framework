package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import configuration.Configuration;
import configuration.MainMethods;
import pom.A21;

public class A21_AlertsExamples {

	private WebDriver driver; // Declare a WebDriver.
	private MainMethods mainMethods; // Declare a MainMethods.
	private Configuration config; // Declare a Configuration.
	private A21 page; // Declare a page object model.
	private String baseURL;
	private String url;
	
	// Click on the button to see and alert and press on the OK button.
	@Test
	public void acceptTheAlertByAcceptMethod() {
		mainMethods.navigateURL(url, page.clickMeButton1); // Navigate to the URL address.
		page.clickMeButton1.click(); // Click on the "Click Me" button.
		WebDriverWait wait = new WebDriverWait(driver, 45); // Declare a wait.
		wait.until(ExpectedConditions.alertIsPresent()); // Wait until the pop-up is present.
		String getThePopUpText = driver.switchTo().alert().getText(); // Get the text of the pop-up window.
		System.out.println("The Alert message is: '"+getThePopUpText+"'"); // Print the text from the pop-up to the console log.
		driver.switchTo().alert().accept(); // Press on the "OK" button of the pop-up window.
	}
	
	// Click on the button to see an alert and press on the Cancel button.
	@Test
	public void cancelTheAlertByDismissMethod() {
		mainMethods.navigateURL(url, page.clickMeButton1); // Navigate to the URL address.
		page.clickMeButton1.click(); // Click on the "Click Me" button.
		WebDriverWait wait = new WebDriverWait(driver, 45); // Declare a wait.
		wait.until(ExpectedConditions.alertIsPresent()); // Wait until the pop-up is present.
		driver.switchTo().alert().dismiss(); // Press on the "Cancel" button of the pop-up window.
	}

	// Click on the button to see an alert and sent text to the pop-up and press on the OK button.
	@Test
	public void sendTextTOAlert()  {
		mainMethods.navigateURL(url, page.clickMeButton2); // Navigate to the URL address.
		page.clickMeButton2.click(); // Click on the "Click Me" button.
		WebDriverWait wait = new WebDriverWait(driver, 45); // Declare a wait.
		wait.until(ExpectedConditions.alertIsPresent()); // Wait until the pop-up is present.
		driver.switchTo().alert().sendKeys("testing Text"); // Fill with the text into the alert window.
		driver.switchTo().alert().accept(); // Press on the "OK" button of the pop-up window.
	}
	
	// Use the AcceptTheAlert method.
	@Test
	public void acceptAlertWithMethod()  {
		mainMethods.navigateURL(url, page.clickMeButton1); // Navigate to the URL address.
		mainMethods.AcceptTheAlert(page.clickMeButton1, "Do you confirm action?"); // Execute the method to accept the alert.
	}
	
	// User the DismissTheAlert method.
	@Test
	public void dismissAlertWithMethod() {
		mainMethods.navigateURL(url, page.clickMeButton1); // Navigate to the URL address.
		mainMethods.DismissTheAlert(page.clickMeButton1, "Do you confirm action?"); // Execute the method to dismiss the alert.
	}

	// Use the FillWithTextInToTheAlert method.
	@Test
	public void fillTextInAlertWithMethod()  {
		mainMethods.navigateURL(url, page.clickMeButton2); // Navigate to the URL address.
		mainMethods.fillWithTextInToTheAlert(page.clickMeButton2, "Please enter your name", "Fill with testing text..."); // Execute the method to fill with text into the alert and accept it.
	}
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods
		config = new Configuration(); // Declare a constructor for Configuration.
		page = new A21(driver); // Declare a constructor for POM..
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "alerts";
		driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
		driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}
}
