package tests;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import configuration.Configuration;
import org.testng.annotations.BeforeMethod;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class A20_2_FillingTheForm {

	private WebDriver driver; // Declare a WebDriver.
	private Faker faker;
	private String baseURL;
	private String url;
	private Configuration config;

	// This example is using faker library to generate fake data - the data will be different every time. This example is showing how we can use faker library.
	@Test
	public void fakerExample() throws UnsupportedFlavorException, IOException {
		WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
		firstName.sendKeys(faker.name().firstName());
		WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		lastName.sendKeys(faker.name().lastName());
		WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
		email.sendKeys(faker.internet().emailAddress());
		WebElement gender = driver.findElement(By.xpath("//*[@id='gender-radio-1']/following-sibling::label"));
		gender.click();
		WebElement phone = driver.findElement(By.xpath("//*[@id='userNumber']"));
		phone.sendKeys(faker.phoneNumber().cellPhone().replace(".", "").replace("(", "").replace(")", "").replace("-", "").replace(" ", ""));
		WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
		dateOfBirth.sendKeys(Keys.CONTROL, "a");
		dateOfBirth.sendKeys("09 Sep 1964");
		dateOfBirth.sendKeys(Keys.ESCAPE);
		WebElement hobbie = driver.findElement(By.xpath("//*[@id='hobbies-checkbox-1']/following-sibling::label"));
		hobbie.click();
		WebElement uploadFile = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
		uploadFile.sendKeys(config.uploadThisFilePath+config.uploadThisFileName);
		WebElement currentAddress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
		currentAddress.sendKeys(faker.lorem().sentence(12, 2) + Keys.ENTER + faker.lorem().sentence(24, 2));
		WebElement submitButton = driver.findElement(By.xpath("//*[@id='submit']"));
		submitButton.sendKeys(Keys.ENTER);
	}
	
	// This example is using Faker library and unique Gmail (using unix timestamp).
	@Test
	public void useUniqueEmail() throws UnsupportedFlavorException, IOException {
		
		long unixTime = Instant.now().getEpochSecond();
		
		WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
		firstName.sendKeys(faker.name().firstName());
		WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		lastName.sendKeys(faker.name().lastName());
		WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
		email.sendKeys("fake.email.fake+"+unixTime+"@gmail.com");
		WebElement gender = driver.findElement(By.xpath("//*[@id='gender-radio-1']/following-sibling::label"));
		gender.click();
		WebElement phone = driver.findElement(By.xpath("//*[@id='userNumber']"));
		phone.sendKeys(faker.phoneNumber().cellPhone().replace(".", "").replace("(", "").replace(")", "").replace("-", "").replace(" ", ""));
		WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
		dateOfBirth.sendKeys(Keys.CONTROL, "a");
		dateOfBirth.sendKeys("09 Sep 1964");
		dateOfBirth.sendKeys(Keys.ESCAPE);
		WebElement hobbie = driver.findElement(By.xpath("//*[@id='hobbies-checkbox-1']/following-sibling::label"));
		hobbie.click();
		WebElement uploadFile = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
		uploadFile.sendKeys(config.uploadThisFilePath+config.uploadThisFileName);
		WebElement currentAddress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
		currentAddress.sendKeys(faker.lorem().sentence(12, 2) + Keys.ENTER + faker.lorem().sentence(24, 2));
		WebElement submitButton = driver.findElement(By.xpath("//*[@id='submit']"));
		submitButton.sendKeys(Keys.ENTER);
	}
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		config = new Configuration(); // Create a constructor of Configuration class.
		faker = new Faker(); // Create a new instance of Chrome driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "automation-practice-form";
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(url); // Navigate to base URL + page.
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
