package com.framework.dp;

import org.testng.annotations.DataProvider;

import com.framework.utils.CSVReader;
import com.framework.utils.ExcelReader;

public class SearchDataProvider {

	@DataProvider(name="DP_FIXED_DATA")
	public static Object[][] getSearchData(){
		return new Object[][] {
			{"Sony tv"}
		};
	}
	

	@DataProvider(name="DP_CSV_DATA")
	public static Object[][] getSearchDataFromCSV(){
		CSVReader reader = new CSVReader("search_data.csv");
		return reader.getData();
	}
	@DataProvider(name="DP_EXCEL_DATA")
	public static Object[][] getSearchDataFromExcel(){
		ExcelReader reader =new ExcelReader("src/test/resources/search_data.xlsx");
		return reader.getData();
	}
}
