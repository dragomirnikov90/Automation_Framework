package tests;
import org.testng.annotations.Test;
import configuration.WaitTypes;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class A15_2_DownloadFileChrome {

	private WebDriver driver; // Declare a WebDriver.
	private String baseURL;
	private WaitTypes wait;

	@Test
	public void downloadFile() {
		WebElement downloadFileButton = driver.findElement(By.xpath("//*[@id='downloadButton']"));
		downloadFileButton.click();
	}

	@BeforeClass
	public void setUp() throws Exception {

		driver = new ChromeDriver(); // Create a new instance of Chrome driver.
		wait = new WaitTypes(driver);
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		options.setExperimentalOption("prefs", prefs);

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
