package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import configuration.Configuration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A20_1_FillingTheForm {

	private WebDriver driver; // Declare a WebDriver.
	private String baseURL;
	private String url;
	private Configuration config;

	// This example is regular and simple.
	@Test
	public void fillingTheFormWithCorrectDateFirstExample() throws UnsupportedFlavorException, IOException {
		WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
		firstName.sendKeys("John");
		WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		lastName.sendKeys("Doe");
		WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
		email.sendKeys("testingfakeemail@testingewr.te");
		WebElement gender = driver.findElement(By.xpath("//*[@id='gender-radio-1']/following-sibling::label"));
		gender.click();
		WebElement phone = driver.findElement(By.xpath("//*[@id='userNumber']"));
		phone.sendKeys("2342323423");
		WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
		dateOfBirth.sendKeys(Keys.CONTROL, "a");
		dateOfBirth.sendKeys("09 Sep 1964");
		dateOfBirth.sendKeys(Keys.ESCAPE);
		WebElement hobbie = driver.findElement(By.xpath("//*[@id='hobbies-checkbox-1']/following-sibling::label"));
		hobbie.click();
		WebElement uploadFile = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
		uploadFile.sendKeys(config.uploadThisFilePath+config.uploadThisFileName);
		WebElement currentAddress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
		currentAddress.sendKeys("test" + Keys.ENTER + "test2");
		WebElement submitButton = driver.findElement(By.xpath("//*[@id='submit']"));
		submitButton.sendKeys(Keys.ENTER);
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		config = new Configuration(); // Create a constructor of Configuration class.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "automation-practice-form";
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(url); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
