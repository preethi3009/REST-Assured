package utils;

public class ExcelUtilsTest {
	
	public static void main(String[] args) {
		
//		String excelPath = "./Data/TestData.xlsx";
		String excelPath = "./Data/TestData.xls";
		String sheetName = "Sheet1";
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		excel.getRowCount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
		excel.getCellData(1, 2);
		
	}

}
