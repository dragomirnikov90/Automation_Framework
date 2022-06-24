package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class A09_ClickButtons {

	private WebDriver driver; // Declare a WebDriver.
	private Actions actions; // Declare an Action.

	String baseURL;

	// Click using left mouse button.
	@Test
	public void clickButton() {
		WebElement clickButton = driver.findElement(By.xpath("//button[starts-with(text(),'Click Me')]"));
		clickButton.click();
	}
	
	// Click using enter button.
	@Test
	public void clickButtonUsingSendKeys() {
		WebElement clickButton = driver.findElement(By.xpath("//button[starts-with(text(),'Click Me')]"));
		clickButton.sendKeys(Keys.ENTER);
	}
	
	// Click using right mouse button.
	@Test
	public void rightClickButton() {
		WebElement rightClickButton = driver.findElement(By.xpath("//*[@id='rightClickBtn']"));
		actions.contextClick(rightClickButton).perform();
	}
	
	// Double click using left mouse button.
	@Test
	public void doubleClickButton() {
		WebElement doubleClickButton = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
		actions.doubleClick(doubleClickButton).perform();
	}

	@BeforeClass
	public void setUp() {
		driver  = new ChromeDriver(); // Create a new instance of Chrome driver.
		actions = new Actions(driver); // Create a new instance of Action driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(baseURL + "buttons"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
