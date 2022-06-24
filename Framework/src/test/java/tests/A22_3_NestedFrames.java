package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import configuration.Configuration;
import configuration.MainMethods;
import pom.A22_3;

public class A22_3_NestedFrames {

	private WebDriver driver; // Declare a WebDriver.
	private MainMethods mainMethods; // Declare a MainMethods.
	private Configuration config; // Declare a Configuration.
	private A22_3 page; // Declare a page object model.
	private String baseURL;
	private String url;
	

	@Test
	public void nestedFramesExample() {
		mainMethods.navigateURL(url, page.verifyElement1); // Navigate to the URL address.
		mainMethods.changeToIframeById("frame1", page.bodyLocator);
		System.out.println("The copied text from 1st iFrame is: "+mainMethods.getText(page.bodyLocator));
		mainMethods.changeToIframeByIndex(0, page.paragrahLocator);
		System.out.println("The copied text from 2nd iFrame is: "+mainMethods.getText(page.paragrahLocator));
		mainMethods.changeFromIframeToDefaultHTML(page.defaultHtmlTextLocator);
		System.out.println("The copied text from default HTML is: "+mainMethods.getText(page.defaultHtmlTextLocator));
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods
		config = new Configuration(); // Declare a constructor for Configuration.
		page = new A22_3(driver); // Declare a constructor for POM..
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "nestedframes";
		driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
		driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
