package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import configuration.MainMethods;
public class A19_ElementNotFound {

	private WebDriver driver; // Declare a WebDriver.
	private String baseURL;
    private MainMethods mainMethod;
    
	// Check if element is presented on the page.
	@Test
	public void checkForElement() {
		boolean validResult = mainMethod.isElemenstPresent("(//*[contains(text(),'Valid image')]/following-sibling::img)[2]", "xpath");
        System.out.println("The result is: "+validResult);
		boolean invalidResult = mainMethod.isElemenstPresent("(//*[contains(text(),'Valid image')]/following-sibling::img)[3]", "xpath");
        System.out.println("The result is: "+invalidResult);
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		mainMethod = new MainMethods(driver);
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(baseURL + "broken"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
