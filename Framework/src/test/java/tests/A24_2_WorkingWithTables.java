package tests;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import configuration.Configuration;
import configuration.MainMethods;
import configuration.OtherMethods;
import pom.A24_2;

public class A24_2_WorkingWithTables {

  private WebDriver driver; // Declare a WebDriver.
  private MainMethods mainMethods; // Declare a MainMethods.
  private OtherMethods otherMethods; // Declare a OtherMethods.
  private Configuration config; // Declare a Configuration
  private Random random;
  private A24_2 page; // Declare a page object model.
  private Faker faker;
  private String baseURL;
  private String url;

  // Example to work with tables 2.
  @Test
  public void tableExample2() {  
	// Declare variables.
    String firstNameValue = faker.name().firstName()+otherMethods.unixTime();
    String lastNameValue = faker.name().lastName();
    String emailValue = faker.internet().safeEmailAddress();
    String ageValue = Integer.toString(random.ints(18, 90).findFirst().getAsInt());
    String salaryValue = Integer.toString(random.ints(500, 10000).findFirst().getAsInt());
    String departmentValue = faker.lorem().word();
    
    String firstNameValueEdited = faker.name().firstName()+otherMethods.unixTime();
    String lastNameValueEdited = faker.name().lastName();
    String emailValueEdited = faker.internet().safeEmailAddress();
    String ageValueEdited = Integer.toString(random.ints(18, 90).findFirst().getAsInt());
    String salaryValueEdited = Integer.toString(random.ints(500, 10000).findFirst().getAsInt());
    String departmentValueEdited = faker.lorem().word();
    
    /** 1. Navigate to: https://demoqa.com/webtables . */ 
    mainMethods.navigateURL(url, page.addButton); // Navigate to URL.
    /** 2.	Press on the “Add” button. */
    mainMethods.clickMethod(page.addButton, page.firstNameInputTextElement); // Press on the "Add" button.
    /** 3.	Fill the form correct. */
    page.fillDataIntoTheTableForm(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue);
    /** 4.	Press on the “Submit” button. */
    mainMethods.clickMethod(page.submitButton, page.addButton); // Press the "Submit" button.
    /** 5.	Verify that the saved data is showed into the report. */
    page.verifyDataInTable(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue);  
    /** 6.	Try to search for newly added record by: “First Name”, “Last Name”, “Age”, “Email”, “Salary”, “Department”. */
    page.verifySearchFunctionalityMainMethod(firstNameValue, lastNameValue, ageValue, emailValue, salaryValue, departmentValue, "false");
    /** 7.	Press on the edit icon of newly added record. */
    page.editLastRecord(page.allEditElements);
    /** 8.	Edit the data with a new one. */
    page.fillDataIntoTheTableForm(firstNameValueEdited, lastNameValueEdited, emailValueEdited, ageValueEdited, salaryValueEdited, departmentValueEdited);
    /** 9.	Press on the “Submit” button. */
    mainMethods.clickMethod(page.submitButton, page.addButton); // Press the "Submit" button.
    /** 10.	Verify that the saved data is showed into the report. */
    page.verifyDataInTable(firstNameValueEdited, lastNameValueEdited, emailValueEdited, ageValueEdited, salaryValueEdited, departmentValueEdited);
    /** 11.	Press on the delete icon. */
    page.editLastRecord(page.allDeleteElements);
    /** 12.	Verify that the record was deleted from the report. */
    page.verifySearchFunctionalityMainMethod(firstNameValueEdited, lastNameValueEdited, ageValueEdited, emailValueEdited, salaryValueEdited, departmentValueEdited, "true");
    /** 13.	Execute steps 2-5, 10 times. */
    page.steps2to5InMethod(10);
  }
     
  @BeforeClass
  public void setUp() {
    driver = new ChromeDriver(); // Create a new instance of Chrome driver.
    mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods.
    otherMethods = new OtherMethods(); // Declare a constructor for OtherMethods.
    config = new Configuration(); // Declare a constructor for Configuration.
    page = new A24_2(driver); // Declare a constructor for POM.
    random = new Random();
    faker = new Faker();
    baseURL = "https://demoqa.com/"; // Declare a base URL value.
    url = baseURL + "webtables";
    driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
    driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }
}