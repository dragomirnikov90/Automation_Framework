package base;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
import com.github.javafaker.Faker;
import configuration.OtherMethods;
import configuration.WaitTypes;
import dataDrivenTesting.ImportDataFromExcel;
import configuration.Configuration;
import configuration.MainMethods;

public class BaseTestClass {

    public WebDriver driver; // Declare a WebDriver.
    public MainMethods mainMethods; // Declare a MainMethods.
    public OtherMethods otherMethods; // Declare a OtherMethods.
    public Configuration config; // Declare a Configuration.
    public WaitTypes wait; // Declare a wait.
    public String url; // Declare a url.
    public SoftAssert softassert;
    public Faker faker;
    public Random random;
    public ImportDataFromExcel excel;
	
    /**
     * This class is used to set the configuration methods, that we are using in test classes.
     * If you want to turn on the messages in the methods you need to set the value to 'on' of the 'messages' variable from the 'configuration.Configuration' class.
     */

    /**
     * This method is used to declare all needed code that will be executed into the @BeforeMethod annotation.
     * 
     * @param endpoint				- provide the end point where we want to navigate. If we will not use end point - use 'null' value.
     */
    @SuppressWarnings("unused")
	public void setUp(String endpoint) {
        config = new Configuration(); // Declare a constructor for Configuration.
        otherMethods = new OtherMethods(); // Declare a constructor for OtherMethods.
        softassert = new SoftAssert(); // Declare an instance for softAssert.
        faker = new Faker();
        random = new Random();
        /** This if-else statement is used for configuration about usage of system property or environment variable for browser drivers. */
        if (Configuration.useSystemPropertyForBrowserDriver == "yes") {
	     	otherMethods.messagesMetohd("Message: We are using System Property for setting up the browser driver path.");
            /** This if-else statement is used for setting up the system property for browser driver. */
            if (Configuration.browser == "firefox") {
                System.setProperty("webdriver.gecko.driver", Configuration.browsersDriverPath + "geckodriver.exe"); // Declare a system property with the path of the Gecko driver path.
            } else if (Configuration.browser == "chrome") {
                System.setProperty("webdriver.chrome.driver", Configuration.browsersDriverPath + "chromedriver.exe"); // Declare a system property with the path of the Chrome driver path.
            } else {
                System.out.println("ERROR! It seems that you doesn't add correct value into the 'browser' variable from the Configuration class. Please review the value of the 'browser' String.");
            } 
        } else if (Configuration.useSystemPropertyForBrowserDriver == "no") {
	     	otherMethods.messagesMetohd("Message: We are using Environment Variable for setting up the browser driver path.");
	     	otherMethods.messagesMetohd("Message: If you are getting error you need to set the path of the folder where you put the browser drivers.");
        } else {
            System.out.println("ERROR! It seems that you doesn't add correct value into the 'useSystemPropertyForBrowserDriver' variable from the Configuration class. Please review the value of the 'useSystemPropertyForBrowserDriver' String.");
        }
        /** This if-else statement is used for starting the browser driver */
        if (Configuration.browser == "firefox") {
            driver = new FirefoxDriver(); // Create a new instance of FireFox driver. 
        } else if (Configuration.browser == "chrome") {
            driver = new ChromeDriver(); // Create a new instance of Chrome driver.
        } else {
            System.out.println("ERROR! It seems that you doesn't add correct value into the 'browser' variable from the Configuration class. Please review the value of the 'browser' String.");
        }
        mainMethods = new MainMethods(driver); // Declare a constructor for MainMethods.
        wait = new WaitTypes(driver); // Declare a constructor for WaitTypes.
        driver.manage().window().maximize(); // Set opened browser to 100% width and- 100% high.
        driver.manage().timeouts().implicitlyWait(config.timeOut, TimeUnit.SECONDS); // Set Implicit Wait.	
        url = Configuration.baseURL + endpoint; // Set url.
     	otherMethods.messagesMetohd("Message: The 'setUp' method was executed. This method contains all needed code that will be executed into the @BeforeMethod annotation.");
    }
    
    
    /**
     * This method is used to read data from Excel file (data driven testing).
     * 
     * @param excelFileName			- provide the name of the used Excel file. If we will not use Excel file for our testing data - use 'null' value.
     * @param excelSheetName		- provide the name of the used Excel sheet. If we will not use Excel file for our testing data - use 'null' value.
     */
    public void dataDriven(String excelFileName, String excelSheetName) {
        excel = new ImportDataFromExcel(); // Create a new constructor for ImportDataFromExcel;
        excel.setExcelFile(config.excelFilePath+excelFileName, excelSheetName); // Execute the setExcelFile method. This is used to set the direction of the Excel file path and Excel sheet name.
     	otherMethods.messagesMetohd("Message: The 'dataDriven' method was executed. The automation read data from file '"+config.excelFilePath+excelFileName+"' and read data from sheet '"+excelSheetName+"'.");
    }

    /**
     * This method is used to declare all needed code that will be executed into the @AfterMethod annotation.
     */
    public void terminate() {
        driver.quit(); // Close the browser when the test is done.
     	otherMethods.messagesMetohd("Message: The 'terminate' method was executed. This method contains all needed code that will be executed into the @@AfterMethod annotation.");
    }

}