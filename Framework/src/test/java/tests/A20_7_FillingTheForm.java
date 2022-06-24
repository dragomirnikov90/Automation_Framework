package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import configuration.OtherMethods;
import configuration.WaitTypes;
import configuration.Configuration;
import configuration.MainMethods;
import pom.A20_7;

public class A20_7_FillingTheForm {

	private WebDriver driver; // Declare a WebDriver.
	private MainMethods mainMethods; // Declare a MainMethods.
	private OtherMethods otherMethods; // Declare a OtherMethod.
	private Configuration config; // Declare a Configuration.
	private SoftAssert softassert;
	private A20_7 page; // Declare a page object model.
	private Faker faker;
	private String baseURL;
	private String teMinutesMailUrl;
	private String url;
	private WaitTypes wait;

	// This example is showing Assertions of inputed and output data.
	@Test
	public void asserts() throws UnsupportedFlavorException, IOException  {
		// Define the imputed data.
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String phoneNumner = otherMethods.randomString("0123456789");
		String InputDateOfBirth = "09 Sep 1964";
		String uploadFile = config.uploadThisFilePath+config.uploadThisFileName;
		String text = faker.lorem().sentence(24, 5);
		String genderExpectedResult = null;
		String dateOfBirthValue = null;
		String OutputDateOfBirth = null;		
		String[] subjectsValues = {"Maths", "Accounting", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Economics", "Social Studies", "Civics", "Biology", "Hindi", "English", "Arts", "History"}; // Create a new collection with 'Subjects' values.
		String subjectsExpectedResult = null;
		WebElement[] hobbiesElements =  {page.hobbie1, page.hobbie2,  page.hobbie3}; // Create a new collection with 'Hobbies' values.
		String hobbiesExpectedResult = null;
		String cityActualResult = null;
		
		// First we need to open email address.
		mainMethods.navigateURL(teMinutesMailUrl, page.confirmText10minutesMail_Page);
		page.copyEmail.click();
		// We call this method from the class "OtherMethods". We are getting the copied data from the clip board here.
		String copyEmail = otherMethods.clickboardData();
		// Lets open new tab and switch the focus of the Selenium to newly opened tab.
		mainMethods.openNewBrowserTab(1, url, page.firstName);
		mainMethods.fillWithText(firstName, page.firstName);
		mainMethods.fillWithText(lastName, page.lastName);
		mainMethods.fillWithText(copyEmail, page.email);	
		genderExpectedResult = page.selectRandomGender();	
		mainMethods.fillWithText(phoneNumner, page.phone);
		page.dateOfBirth.sendKeys(Keys.CONTROL, "a");
		mainMethods.fillWithTextWithoutClearing(InputDateOfBirth, page.dateOfBirth);
		dateOfBirthValue = page.dateOfBirth.getAttribute("value"); // We need to take the filled data into the "Date of Birth" input text element.
		OutputDateOfBirth = page.parseMonths(dateOfBirthValue);
		page.dateOfBirth.sendKeys(Keys.ESCAPE);
		List < String > subjects = new ArrayList < String > (); // Create a new array.
		subjects.addAll(Arrays.asList(subjectsValues)); // Add the collection to the array.
		subjectsExpectedResult = page.selectRandomSubjects(subjects, 13);
		hobbiesExpectedResult = page.selectRandomHobbies(hobbiesElements, 2);		
		page.uploadFile.sendKeys(uploadFile);	  
		String stateActualResult = page.selectRandomStateAndCityDropDownValues(page.stateOrCityDropDownListValues, page.stateDropDownList, page.stateDropDownListActualResultValue, "no");
		if (stateActualResult != null)
			{cityActualResult = " " + page.selectRandomStateAndCityDropDownValues(page.stateOrCityDropDownListValues, page.cityDropDownList, page.cityDropDownListActualResultValue, "yes");}	
		else {
			stateActualResult = "";
			cityActualResult = "";
		}	
		mainMethods.fillWithText(text, page.currentAddress);		
		mainMethods.clickEnterButton(page.submitButton, page.assertStudentName);
		
		 // Asserts.
		 Assert.assertEquals(page.assertStudentName.getText(), firstName + " " + lastName);
		 Assert.assertEquals(page.assertStudentEmail.getText(), copyEmail);
		 Assert.assertEquals(page.assertGender.getText(), genderExpectedResult);
		 Assert.assertEquals(page.assertMobile.getText(), phoneNumner);
		 Assert.assertEquals(page.assertDateOfBirth.getText(), OutputDateOfBirth);
		 Assert.assertEquals(page.assertSubjects.getText(), subjectsExpectedResult);
		 Assert.assertEquals(page.assertHobbies.getText(), hobbiesExpectedResult);
		 Assert.assertEquals(page.assertPicture.getText(), config.uploadThisFileName);
		 Assert.assertEquals(page.assertAddress.getText(), text);
		 Assert.assertEquals(page.assertStateNadCity.getText(), stateActualResult + cityActualResult);
	} 
	 
	// This example is showing the final view of the test. The test now is looking perfect.
	@Test
	public void finalTestView() throws UnsupportedFlavorException, IOException  {
		// Define the imputed data.
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String copyEmail = null;
		String genderExpectedResult = null;
		String phoneNumner = otherMethods.randomString("0123456789");
		String dateOfBirthValue = null;
		String outputDateOfBirth = null;
		List < String > subjects = new ArrayList < String > (); // Create a new array for subjects.
		String[] subjectsValues = {"Maths", "Accounting", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Economics", "Social Studies", "Civics", "Biology", "Hindi", "English", "Arts", "History"}; // Create a new collection with 'Subjects' values.
		String subjectsExpectedResult = null;
		WebElement[] hobbiesElements =  {page.hobbie1, page.hobbie2,  page.hobbie3}; // Create a new collection with 'Hobbies' values.
		String hobbiesExpectedResult = null;
		String uploadFile = config.uploadThisFilePath+config.uploadThisFileName;
		String currentAddress = faker.lorem().sentence(24, 5);
		String staetAndCity = null;	
	
		/** 1.	Navigate to: https://10minemail.com . */
		mainMethods.navigateURL(teMinutesMailUrl, page.confirmText10minutesMail_Page);
		/** 2.	Copy the email. */
		page.copyEmail.click();
		/** 3.	Navigate to: https://demoqa.com/automation-practice-form. */
		mainMethods.openNewBrowserTab(1, url, page.firstName); // Lets open new tab and switch the focus of the Selenium to newly opened tab.
		/** 4.	Fill with correct data into the “First Name” input text element. */
		mainMethods.fillWithText(firstName, page.firstName);
		/** 5.	Fill with correct data into the “Last Name” input text element. */
		mainMethods.fillWithText(lastName, page.lastName);
		/** 6.	Fill with correct data into the “Email” input text element. */
		copyEmail = otherMethods.clickboardData(); // We call this method from the class "OtherMethods". We are getting the copied data from the clip board here.
		mainMethods.fillWithText(copyEmail, page.email);	
		/** 7.	Select random correct option from the “Gender” section. */
		genderExpectedResult = page.selectRandomGender();	
		/** 8.	Fill with correct data into the “Mobile Number” input text element. */
		mainMethods.fillWithText(phoneNumner, page.phone);
		/** 9.	Fill with correct data into the “Date of Birth” input text element. */
		page.selectRandomDateOfBirthValue();
		dateOfBirthValue = page.dateOfBirth.getAttribute("value"); // We need to take the filled data into the "Date of Birth" input text element.
		outputDateOfBirth = page.parseMonths(dateOfBirthValue);	
		/** 10.	Select random correct date for “Subjects”. */
		subjects.addAll(Arrays.asList(subjectsValues)); // Add the collection to the array.
		subjectsExpectedResult = page.selectRandomSubjects(subjects, 13);
		/** 11.	Check random correct value/s from the “Hobbies” section. */
		hobbiesExpectedResult = page.selectRandomHobbies(hobbiesElements, 2);			
		/** 12.	Upload random correct picture file. */
		page.uploadFile.sendKeys(uploadFile);	  
		/** 13.	Fill with correct data into the “Current Address” input text element. */
		mainMethods.fillWithText(currentAddress, page.currentAddress);
		/** 14.	Select random correct date for “State and City” inputs. */
		staetAndCity = page.selectRandomStateAndCity();
		/** 15.	Press on the “Submit” button. */
		mainMethods.clickEnterButton(page.submitButton, page.assertStudentName);
	
		wait.staticWait(5); // We are using static wait because sometimes the automation test fails. So we need this to make the test more stable. This is not a good practice, but sometimes we are not able to wait by different way.
		
		/** 16.	Verify that the imputed date are saved correctly into the system. */
		/** Assertion */
		softassert.assertEquals(page.assertStudentName.getText(), firstName + " " + lastName);
		softassert.assertEquals(page.assertStudentEmail.getText(), copyEmail);
		softassert.assertEquals(page.assertGender.getText(), genderExpectedResult);
		softassert.assertEquals(page.assertMobile.getText(), phoneNumner);
		softassert.assertEquals(page.assertDateOfBirth.getText(), outputDateOfBirth);
		softassert.assertEquals(page.assertSubjects.getText(), subjectsExpectedResult);
		softassert.assertEquals(page.assertHobbies.getText(), hobbiesExpectedResult);
		softassert.assertEquals(page.assertPicture.getText(), config.uploadThisFileName);
		softassert.assertEquals(page.assertAddress.getText(), currentAddress);
		softassert.assertEquals(page.assertStateNadCity.getText(), staetAndCity);
		softassert.assertAll();
	}

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods
		otherMethods = new OtherMethods(); // Declare a constructor for OtherMethods.
		config = new Configuration(); // Declare a constructor for Configuration.
		softassert = new SoftAssert();
		wait = new WaitTypes(driver);// Declare a constructor for WaitTypes class.
		page = new A20_7(driver); // Declare a constructor for POM.
		faker = new Faker(); // Create a new instance of Faker driver.
		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		url = baseURL + "automation-practice-form";
		teMinutesMailUrl = "https://10minemail.com/";
		driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
		driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.
		
	}

	@AfterMethod
	public void afterClass() {
	driver.quit();
	}
}
