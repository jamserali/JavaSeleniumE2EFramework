package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException {
		String path="testData/testdata.xlsx";
		ExcelUtils excel = new ExcelUtils(path,"sheet1");
		
		int totalrows = excel.getRowCount();
		int totalcolumn = excel.getColumnCount(0);
		
		String loginData[][] =  new String[totalrows][totalcolumn];
		for(int i=0; i<totalrows; i++) {
			for(int j=0;j<totalcolumn;j++) {
				loginData[i-1][j]=excel.getCellData(i, j);
			}
		}
				
        excel.close(); 
	
		return loginData;
		
	}
	
	
}
