package tests;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "DataForPost") //provide a name for referring
	public Object[][] dataForPost() {
		
//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "Mary";
//		data[0][1] = "Jane"; //Ctrl + / for commenting
//		data[0][2] = 2;
//		
//		data[1][0] = "George";
//		data[1][1] = "Clooney";
//		data[1][2] = 1;
//		
//		return data;
		
		return new Object[][] {
			
			{"Elon", "Musk", 2}, 
			{"Joe", "Biden", 1}
		};
	}
	

	@DataProvider(name = "DataForDelete")
	public Object[] dataForDelete() {
		
		return new Object[] {
				
				5,6,7,8	
		};
	}
	

}
