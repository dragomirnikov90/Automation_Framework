package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import configuration.Configuration;
import configuration.MainMethods;
import pom.A24_2;

public class A25_2_ClassAnotationsExample {

  private WebDriver driver; // Declare a WebDriver.
  private MainMethods mainMethods; // Declare a MainMethods.
  private Configuration config; // Declare a Configuration
  private A24_2 page; // Declare a page object model.
  private String baseURL;
  private String url;

  // Test Example 1.
  @Test
  public void textExample1() {  
    mainMethods.navigateURL(url, page.addButton); // Navigate to URL.
  }
  
  // Test Example 2.
  @Test
  public void textExample2() {  
    mainMethods.navigateURL(url, page.addButton); // Navigate to URL.
  }
  
  // Test Example 3.
  @Test
  public void textExample3() {  
    mainMethods.navigateURL(url, page.addButton); // Navigate to URL.
  }
  
  // This will be executed before first @Test method execution. It will be executed one only time throughout the test case.
  @BeforeClass()
  public void beforeClass() {
    url = baseURL + "webtables";
  }
 
  // It will run only once, before all tests in the suite are executed.
  @BeforeSuite()
  public void beforeSuite() {
	  baseURL = "https://demoqa.com/"; // Declare a base URL value.
  }
  
  // This will be executed before every @test annotated method.
  @BeforeMethod
  public void beforeTest() {
	  driver = new ChromeDriver(); // Create a new instance of Chrome driver.
	  mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods.
	  config = new Configuration(); // Declare a constructor for Configuration.
	  page = new A24_2(driver); // Declare a constructor for POM.
	  driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
	  driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.	  
  }
  
  // This will be executed after every @test annotated method.
  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }  
}
