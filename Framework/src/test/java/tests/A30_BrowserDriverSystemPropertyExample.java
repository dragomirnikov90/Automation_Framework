package tests;

import org.testng.annotations.Test;
import base.BaseTestClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.testng.annotations.AfterClass;

public class A30_BrowserDriverSystemPropertyExample extends BaseTestClass {

	// This test class should be executed from the A30_ParallelExecutionSuite.xml suit.
    // Example shows how to set system property for browser driver.
    @Test
    public void getScreenShotExampleWhenMethodFails() {
        driver.get("https://google.com"); // Navigate to URL.
    }

    @BeforeClass
    public void beforeClass() {
        setUp(null);

    }

    @AfterClass
    public void afterClass() throws IOException {
        terminate();
    }
}
