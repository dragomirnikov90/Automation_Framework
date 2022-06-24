package tests;

import org.testng.annotations.Test;
import configuration.Configuration;
import configuration.WaitTypes;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;

public class A15_3_DownloadFileFireFox {

	private WebDriver driver; // Declare a WebDriver.
	private String baseURL;
	private Configuration config;
	private WaitTypes wait;

	@Test
	public void downloadFile() {
		WebElement downloadFileButton = driver.findElement(By.xpath("//*[@id='downloadButton']"));
		downloadFileButton.click();
	}

	@BeforeClass
	public void setUp() throws Exception {
		config = new Configuration();
		
		// Define Download Option for FireFox Browser;
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.dir", config.downloadFolderPath);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/jpeg");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.useWindow", true);
		profile.setPreference("browser.download.manager.focusWhenStarting", true);
		profile.setPreference("browser.download.manager.showAlertOnComplete", true);
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		driver = new FirefoxDriver(options);
		wait = new WaitTypes(driver);

		baseURL = "https://demoqa.com/"; // Declare a base URL value.
		driver.manage().window().maximize(); // Set opened browser to 100% width and 100% high.
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); // Set Implicit Wait.
		driver.get(baseURL + "upload-download"); // Navigate to base URL + page.

	}

	@AfterClass
	public void afterClass() {
		wait.staticWait(10); // We need this static wait because we need to finish the downloading file.
		driver.quit();
	}
}
