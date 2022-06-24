package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class A11_RadioButton {

	private WebDriver driver; // Declare a WebDriver.
	private String baseURL;

	// Click on the enabled radio button.
	@Test
	public void clickRadioButton() {
		WebElement radioButton = driver.findElement(By.xpath("//*[@id='yesRadio']/following-sibling::label"));
		radioButton.click();
	}

	// Click on the enabled radio button.
	@Test
	public void clickRadioButton2() {
		WebElement impressiveRadioButton = driver.findElement(By.xpath("//*[@id='impressiveRadio']/following-sibling::label"));
		impressiveRadioButton.click();
	}

	// Check if radio button is enabled and ready for click action when the radio button is not enabled.
	@Test
	public void checkIfRadioButtonIsClicable() {

		WebElement disabledRadioButton = driver.findElement(By.xpath("//*[@id='noRadio']"));
		if (disabledRadioButton.isEnabled()) {
			System.out.println("Checkbox can be clicked.");
			disabledRadioButton.click();
		} else {
			System.out.println("Checkbox is disabled and cannot be clicked.");
		}
	}

	// Check if radio button is enabled and ready for click action using isEnabled method.
	@Test
	public void clickRadioButtonAndCheckIfItsClicable() {
		WebElement checkIfRadioButtonClicable = driver.findElement(By.xpath("//*[@id='yesRadio']"));
		WebElement radioButton = driver.findElement(By.xpath("//*[@id='yesRadio']/following-sibling::label"));
		if (checkIfRadioButtonClicable.isEnabled()) {
			System.out.println("Checkbox can be clicked.");
			radioButton.click();
		} else {
			System.out.println("Checkbox is disabled and cannot be clicked.");
		}
	}

	// Check if radio button is enabled and ready for click action by finding "disabled" attribut in the element.
	@Test
	public void clickRadioButtonAndCheckIfItsClicableVariant2() {
		WebElement checkIfRadioButtonClicable = driver.findElement(By.xpath("//*[@id='yesRadio']"));
		String checkRadioButton = checkIfRadioButtonClicable.getAttribute("disabled");
		WebElement radioButton = driver.findElement(By.xpath("//*[@id='yesRadio']/following-sibling::label"));
		if (checkRadioButton != "disabled") {
			System.out.println("Checkbox can be clicked.");
			radioButton.click();
		} else {
			System.out.println("Checkbox is disabled and cannot be clicked.");
		}
	}
	
	
	// Check if radio button is already selected.
	@Test
	public void checkIfRadioButtonIsALreadySelected() {
		// First we need to click on the radio button to make sure that the button is selected.
		WebElement yesRadioButton = driver.findElement(By.xpath("//*[@id='yesRadio']/following-sibling::label"));
		yesRadioButton.click();
		// Then we need to check if the radio button is already selected.
		WebElement checkRadioButton = driver.findElement(By.xpath("//*[@id='yesRadio']"));
		if (checkRadioButton.isSelected()) {
			System.out.println("Checkbox is already selected.");
		} else {
			System.out.println("Checkbox is not selected and now we can click on it.");
			yesRadioButton.click();
		}
	}

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(baseURL + "radio-button"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
