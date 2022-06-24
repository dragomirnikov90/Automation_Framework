package tests;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import configuration.Configuration;
import org.testng.annotations.BeforeClass;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A20_3_FillingTheForm {

	private WebDriver driver; // Declare a WebDriver.
	private Faker faker;
	private String baseURL;
	private String url;
	private String clickboardData;
	private Configuration config;

	// This example is improving the second example. Lets open 10 minutes mail and copy the email address.
	@Test
	public void improoveSecondExample() throws UnsupportedFlavorException, IOException {
		// First we need to open email address.
		driver.get("https://10minemail.com/");
		WebElement copyEmail = driver.findElement(By.xpath("(//button[@data-clipboard-action='copy'])[2]"));
		copyEmail.click();
		
		// Get data from the click board.
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clickboardData = (String) clipboard.getData(DataFlavor.stringFlavor);
		if (clickboardData != null)
		{
		System.out.println("The copied email address is: " + clickboardData);
		}
		else {
		System.out.println("It seems that the clickboard is empty.");
		}
		
		// Lets open new tab and switch the focus of the Selenium to newly opened tab.
	    ((JavascriptExecutor)driver).executeScript("window.open()"); // We can open a new tab window using the JavascriptExecutor.
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); // Declare an ArrayList used for different browser tabs.
	    driver.switchTo().window(tabs.get(1)); // Switch to the second browser tab.
	    driver.get(baseURL + "automation-practice-form"); // Navigate to URL.

		WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
		firstName.sendKeys(faker.name().firstName());
		WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
		lastName.sendKeys(faker.name().lastName());
		WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
		email.sendKeys(clickboardData);
		WebElement gender = driver.findElement(By.xpath("//*[@id='gender-radio-1']/following-sibling::label"));
		gender.click();
		WebElement phone = driver.findElement(By.xpath("//*[@id='userNumber']"));
		phone.sendKeys(faker.phoneNumber().phoneNumber().replace("-","").replace(".", "").replace("(", "").replace(")", "").replace(" ", ""));
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
	
	@BeforeClass
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
