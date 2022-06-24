package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class A16_Assertions {

	private WebDriver driver;
	private String baseURL;

	// Regular Assertion.
	@Test
	public void regularAssert() {
		
		// First lets make action.
		WebElement radioButton = driver.findElement(By.xpath("//*[@id='yesRadio']/following-sibling::label"));
		radioButton.click();
		
		// The system shows a message after the action - so we can use this message for assertion.
		WebElement copyText = driver.findElement(By.xpath("//span[@class='text-success']"));
		String actualResult = copyText.getText();
		String expectedResult = "Yes";
		
		// Make a regular assertion.
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	// Soft Assertion.
	@Test
	public void softAsser() {
		
		SoftAssert softAssert = new SoftAssert();
		
		// First lets make first action.
		WebElement radioButton = driver.findElement(By.xpath("//*[@id='yesRadio']/following-sibling::label"));
		radioButton.click();		
		// The system shows a message after the action - so we can use this message for assertion.
		WebElement copyText1 = driver.findElement(By.xpath("//span[@class='text-success']"));
		String actualResult1 = copyText1.getText();
		String expectedResult1 = "Yes";
		
		// Seconds lets make second action.
		WebElement impressiveRadioButton = driver.findElement(By.xpath("//*[@id='impressiveRadio']/following-sibling::label"));
		impressiveRadioButton.click();
		// The system shows a message after the action - so we can use this message for assertion.
		WebElement copyText2 = driver.findElement(By.xpath("//span[@class='text-success']"));
		String actualResult2 = copyText2.getText();
		String expectedResult2 = "Impressive";
		
		softAssert.assertEquals(actualResult1, expectedResult1);
		softAssert.assertEquals(actualResult2, expectedResult2);
		softAssert.assertAll();
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(baseURL+"radio-button"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
