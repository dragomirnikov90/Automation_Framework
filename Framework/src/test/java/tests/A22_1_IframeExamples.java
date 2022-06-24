package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import configuration.Configuration;
import configuration.MainMethods;
import pom.A22_1;

public class A22_1_IframeExamples {

	private WebDriver driver; // Declare a WebDriver.
	private MainMethods mainMethods; // Declare a MainMethods.
	private Configuration config; // Declare a Configuration.
	private A22_1 page; // Declare a page object model.
	private String baseURL;
	private String url;
	
	// Change to the iFrame by iFrame id.
	@Test
	public void changeToIframeByID() {
		mainMethods.navigateURL(url, page.verifyUrlLoaded); // Navigate to the URL address.
		driver.switchTo().frame("frame1"); // Switch to iFrame by ID.
		String textFromIframe = page.iFrameText1.getText(); // Get the text inside the iFrame to verify that we switched correctly.
		System.out.println("The text from the iFrame is: '"+textFromIframe+"'"); // Print the text on the console log.
	}
	
	// Change to the iFrame by switching between main iFrame an default iFrame.
	@Test
	public void changeToIframeByIndex() {
		mainMethods.navigateURL(url, page.verifyUrlLoaded); // Navigate to the URL address.
		int allIframesInThePage = driver.findElements(By.tagName("iframe")).size();
		System.out.println("There are '" +allIframesInThePage + "' iFrames in this page.");
		driver.switchTo().frame(1); // Switch to iFrame by ID.
		String textFromIframe = mainMethods.getText(page.iFrameText1); // Get the text inside the iFrame to verify that we switched correctly.
		System.out.println("The text from the iFrame is: '"+textFromIframe+"'"); // Print the text on the console log.
		driver.switchTo().defaultContent();
		String textFromDefaultPage = mainMethods.getText(page.getThisText); // Get this text outside of the iFrame to verify that we switched correctly from iFrame to the default HTML document.
		System.out.println("The text from default page is: '"+textFromDefaultPage+"'");
	}

	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods
		config = new Configuration(); // Declare a constructor for Configuration.
		page = new A22_1(driver); // Declare a constructor for POM..
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "frames";
		driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
		driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}
}
