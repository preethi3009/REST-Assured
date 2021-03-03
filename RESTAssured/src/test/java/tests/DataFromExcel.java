package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utils.ExcelUtils;

public class DataFromExcel {

	@Test
	public void post() {

		String excelPath = "./Data/TestData.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();

		int rows = excel.getRowCount();

		for (int i=1; i<rows;i++) {

			request.put("firstName", excel.getCellData(i, 0).toString());
			request.put("lastName", excel.getCellData(i, 1).toString());
			request.put("subjectId", Integer.parseInt(excel.getCellData(i, 2).toString()));

			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().	
				post("/users").
			then(). 
				statusCode(201). 
				log().all();	
		}
	}

}
