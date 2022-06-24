package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class A13_SelectDropDownList {

	private WebDriver driver; // Declare a WebDriver.
	private String baseURL;

	// Select Drop-Down list by text.
	@Test
	public void selectDropDownListByText() {
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
		dropDownList.selectByVisibleText("Yellow");
	}

	// Select Drop-Down list by index.
	@Test
	public void selectDropDownListByIndex() {
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
		dropDownList.selectByIndex (5);
	}
	
	// Select Drop-Down list by value.
	@Test
	public void selectDropDownListByValue() {
		Select dropDownList = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
		dropDownList.selectByValue("10");
	}
	
	// Select Drop-Down list by clicking on the drop-down list element and then clicking on the value element.
	@Test
	public void selectDropDownListByClickingOnTheElements() {
		WebElement dropDownList = driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
		dropDownList.click();
		WebElement dropDownListValue = driver.findElement(By.xpath("//*[@id='oldSelectMenu']/option[@value='4']"));
		dropDownListValue.click();
		WebElement ChangeFocus = driver.findElement(By.xpath("//*//*[contains(text(),'Old Style Select Menu')]"));
		ChangeFocus.click();	
	}

	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(baseURL + "select-menu"); // Navigate to base URL + page.
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
