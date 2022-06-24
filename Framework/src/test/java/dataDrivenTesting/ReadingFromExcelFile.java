/** This can works only for Excel 2007+ */

package dataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingFromExcelFile {
	
	public static void main(String[] args) {
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;
		
		/**
		 * This class is used only for example to show how to read data from Excel file.
		 */
		
		// Location of the Excel file.
		String path = "C:\\Users\\test657\\Desktop\\QA Course\\Framework2\\Framework\\ExcelData\\dataDrivenExample.xlsx"; // Define the path of the Excel file.
		String sheetName = "Sheet1"; // Define the name of the sheet from Excel file that we want to use.
		
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			Cell = ExcelWSheet.getRow(0).getCell(0); // get the position of the cell that we want to read.
			String cellData = Cell.getStringCellValue();
			System.out.println("Cell Data: "+cellData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
