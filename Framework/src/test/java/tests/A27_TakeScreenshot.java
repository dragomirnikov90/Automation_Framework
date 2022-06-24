package tests;

import org.testng.annotations.Test;
import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import pom.A27;

public class A27_TakeScreenshot extends BaseTestClass {
    private A27 page; // Declare a page object model.
    private String endpoint = "webtables";

    /** Example shows how to get screenshot when the test fails. */
    @Test
    public void getScreenShotExampleWhemTestFails() {
        mainMethods.navigateURL(url, page.addButton); // Navigate to URL.
        softassert.fail();
        softassert.assertAll();
    }

    /** Example shows how to get screenshot when the method fails. */
    @Test
    public void getScreenShotExampleWhenMethodFails() {
      mainMethods.navigateURL(url, page.fakeLocator); // Navigate to URL.
    }
    @BeforeMethod
    public void beforeMethod() {
        setUp(endpoint);
        page = new A27(driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        /* Create screenshot when test fails. */
    	if (testResult.getStatus() == ITestResult.FAILURE) {
            mainMethods.takeScreenShotInAfterMethod(testResult.getMethod().getMethodName());
        }
    	terminate();
    }
}
