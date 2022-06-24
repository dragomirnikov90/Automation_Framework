package tests;

import org.testng.annotations.Test;
import base.BaseTestClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import dataDrivenTesting.ImportDataFromExcel;

public class A31_UsingDataFromExcel extends BaseTestClass {

	private ImportDataFromExcel excel;
    // Example shows how to set system property for browser driver.
    @Test(dataProvider = "dataProviderName")
    public void getDataFromExcelFile(String username, String password, String gender) {
       System.out.println("The username is: "+ username);
       System.out.println("The password is: "+ password);
       System.out.println("The gender is: "+ gender);
    }

    @BeforeClass
    public void beforeClass() {
        setUp(null);
        excel = new ImportDataFromExcel(); // Create a new constructor for ImportDataFromExcel;
        excel.setExcelFile(config.excelFilePath+config.excelFileName, "Sheet1"); // Execute the setExcelFile method. This is used to set the direction of the Excel file path and Excel sheet name.
    }
    
    @DataProvider(name = "dataProviderName")
    public Object[][] dataProvider() {
    	Object[][] testData = excel.getDataFromExcelFile("begin");
    	return testData;
    }

    @AfterClass
    public void afterClass() throws IOException {
        terminate();
    }
}
