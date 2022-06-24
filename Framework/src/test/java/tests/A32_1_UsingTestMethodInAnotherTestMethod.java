package tests;

import org.testng.annotations.Test;
import base.BaseTestClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.testng.annotations.AfterClass;

public class A32_1_UsingTestMethodInAnotherTestMethod extends BaseTestClass {

    // Example shows how to use this @Test in another @Test.
    @Test
    public void firstTest() {
       System.out.println("This is the fiest @Test.");
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
