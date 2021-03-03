package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	//	static XSSFWorkbook workbook;
	//	static XSSFSheet sheet; 

	static HSSFWorkbook workbook;
	static HSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {

		try {

			//			workbook = new XSSFWorkbook(excelPath); //XSSFWorkbook works for .xlsx files

			InputStream file = new FileInputStream(excelPath); 
			workbook = new HSSFWorkbook(file);               	// HSSFWorkbook for .xls files
			sheet = workbook.getSheet(sheetName);				//get sheet

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
	}

	public static void getRowCount() {

		//To get Project directory path
		//String projDir = System.getProperty("user.dir");
		//String excelPath = projDir + "/Data/TestData.xlsx";
		
		//			String excelPath = "./Data/TestData.xlsx";
		//
		//			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
		//			XSSFSheet sheet = workbook.getSheet("Sheet1");		

		int rowCount = sheet.getPhysicalNumberOfRows(); //get number of rows
//		System.out.println(rowCount);

	}

	public static void getCellData(int rowNum, int colNum) {

		//			String excelPath = "./Data/TestData.xlsx";
		//
		//			XSSFWorkbook workbook = new XSSFWorkbook(excelPath); 
		//			XSSFSheet sheet = workbook.getSheet("Sheet1");			

		//String value = sheet.getRow(1).getCell(0).getStringCellValue(); // to get string values
		//double value = sheet.getRow(1).getCell(2).getNumericCellValue(); //to get numeric values

		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum)); //gets any data type

//		System.out.println(value);
	
	}

}
