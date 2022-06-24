package tests;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import configuration.OtherMethods;
import configuration.Configuration;
import configuration.MainMethods;
import pom.A20_6;

public class A20_6_FillingTheForm {

	private WebDriver driver; // Declare a WebDriver.
	private MainMethods mainMethods; // Declare a MainMethods.
	private OtherMethods otherMethods; // Declare a OtherMethod.
	private Configuration config; // Declare a Configuration.
	private A20_6 element; // Declare a page object model.
	private Faker faker;
	private String baseURL;
	private String teMinutesMailUrl;
	private String url;

	// This example is showing usage of one method.
	@Test
	public void createMethod() throws UnsupportedFlavorException, IOException  {
		// First we need to open email address.
		driver.get(teMinutesMailUrl);
		element.copyEmail.click();
		
		// We call this method from the class "OtherMethods". We are getting the copied data from the clipboard here.
		String copyEmail = otherMethods.clickboardData();

		// Lets open new tab and switch the focus of the Selenium to newly opened tab.
	    ((JavascriptExecutor)driver).executeScript("window.open()"); // We can open a new tab window using the JavascriptExecutor.
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); // Declare an ArrayList used for different browser tabs.
	    driver.switchTo().window(tabs.get(1)); // Switch to the second browser tab.
	    driver.get(baseURL + "automation-practice-form"); // Navigate to URL.

		element.firstName.sendKeys(faker.name().firstName());
		element.lastName.sendKeys(faker.name().lastName());
		element.email.sendKeys(copyEmail);
		element.gender.click();
		element.phone.sendKeys(faker.phoneNumber().phoneNumber().replace("-","").replace(".", "").replace("(", "").replace(")", "").replace(" ", ""));
		element.dateOfBirth.sendKeys(Keys.CONTROL, "a");
		element.dateOfBirth.sendKeys("09 Sep 1964");
		element.dateOfBirth.sendKeys(Keys.ESCAPE);
		element.hobbie.click();
		element.uploadFile.sendKeys(config.uploadThisFilePath+config.uploadThisFileName);
		element.currentAddress.sendKeys(faker.lorem().sentence(12, 2) + Keys.ENTER + faker.lorem().sentence(24, 2));
		element.submitButton.sendKeys(Keys.ENTER);
	}	

	// This example is showing usage of methods.
	@Test
	public void createMethods() throws UnsupportedFlavorException, IOException  {
		// First we need to open email address.
		mainMethods.navigateURL(teMinutesMailUrl, element.confirmText10minutesMail_Page);
		element.copyEmail.click();
		// We call this method from the class "OtherMethods". We are getting the copied data from the clipboard here.
		String copyEmail = otherMethods.clickboardData();
		// Lets open new tab and switch the focus of the Selenium to newly opened tab.
		mainMethods.openNewBrowserTab(1, baseURL + "automation-practice-form", element.firstName);
		mainMethods.fillWithText(faker.name().firstName(), element.firstName);
		mainMethods.fillWithText(faker.name().lastName(), element.lastName);
		mainMethods.fillWithText(copyEmail, element.email);
		mainMethods.clickCheckBoxRadioButtonWithoutVerify(element.gender);
		mainMethods.fillWithText(otherMethods.randomString("0123456789"), element.phone);
		element.dateOfBirth.sendKeys(Keys.CONTROL, "a");
		mainMethods.fillWithTextWithoutClearing("09 Sep 1964", element.dateOfBirth);
		element.dateOfBirth.sendKeys(Keys.ESCAPE);
		mainMethods.clickCheckBoxRadioButtonWithoutVerify(element.hobbie);
		element.uploadFile.sendKeys(config.uploadThisFilePath+config.uploadThisFileName);
		mainMethods.fillWithText(faker.lorem().sentence(24, 5), element.currentAddress);
		mainMethods.clickEnterButton(element.submitButton, element.confirmTextAutomationPracticeForm_PopUp);
	}
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods.
		otherMethods = new OtherMethods(); // Declare a constructor for OtherMethods.
		config = new Configuration(); // Declare a constructor for Configuration.
		element = new A20_6(driver); // Declare a constructor for POM.
		faker = new Faker(); // Create a new instance of Faker driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "upload-download";
		teMinutesMailUrl = "https://10minemail.com/";
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(url); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
