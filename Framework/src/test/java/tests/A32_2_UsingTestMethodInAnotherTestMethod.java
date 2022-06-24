package tests;

import org.testng.annotations.Test;
import base.BaseTestClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.testng.annotations.AfterClass;

public class A32_2_UsingTestMethodInAnotherTestMethod extends BaseTestClass {
	
	private A32_1_UsingTestMethodInAnotherTestMethod firstTest = new A32_1_UsingTestMethodInAnotherTestMethod();

    // Example shows how to use @Test in this @Test.
    @Test()
    public void secondTest() {
       firstTest.firstTest();
       System.out.println("This is the second @Test.");
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
