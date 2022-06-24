package tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pom.A25_4;
import base.BaseTestClass;

public class A25_4_ClassAnotationsExample extends BaseTestClass {

  private A25_4 page;
  private String endpoint = "text-box";

  // Test Example 1.
  @Test(priority=1, groups = {"positiveTest", "logIn"})
  public void textExample1() {  
    mainMethods.navigateURL(url, page.fullNameInputTextElement); // Navigate to URL.
  }
  
  // Test Example 2.
  @Test(priority=0, groups = {"negativeTest", "logIn"}, timeOut = 45000)
  public void textExample2() {  
    mainMethods.navigateURL(url, page.fullNameInputTextElement); // Navigate to URL.
  }
  
  // Test Example 3.
  @Test(priority=2, groups = {"negativeTest", "logIn"})
  public void textExample3() {  
    mainMethods.navigateURL(url, page.fullNameInputTextElement); // Navigate to URL.
  }
    
  @BeforeMethod
  public void beforeTest() {
	  setUp(endpoint);
	  page = new A25_4(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  terminate();
  }
}

