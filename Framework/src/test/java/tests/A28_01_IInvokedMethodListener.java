package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import listeners.IInvokedMethodListenerClass;

//Example shows how to use the IInvoked Method Listeners.
@Listeners(IInvokedMethodListenerClass.class)
public class A28_01_IInvokedMethodListener {

  @Test
  public void iInvokedMethodListenerExample() {
	  System.out.println("@Test annotation");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("@BeforeClass annotation");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("@AfterClass annotation");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("@BeforeMethod annotation");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("@AfterMethod annotation");
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("@BeforeTest annotation");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("@AfterTest annotation");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("@BeforeSuite annotation");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("@AfterSuite annotation");
  }
}
