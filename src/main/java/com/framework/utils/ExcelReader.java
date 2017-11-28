package com.framework.utils;

import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	String filePath;
	public ExcelReader(String filePath) {
		this.filePath = filePath;
	}
	
	public Object[][] getData(){
		Object[][] data=null;
		try {
			Workbook workbook = new XSSFWorkbook(filePath);
			Sheet sheet = workbook.getSheetAt(0);
			
			int firstRow = sheet.getFirstRowNum()+1;
			int lastRow = sheet.getLastRowNum();
			data = new Object[lastRow-firstRow+1][];
			for (int i = firstRow; i <= lastRow; i++) {
				Row row = sheet.getRow(i);
				int cellCount = row.getLastCellNum() - row.getFirstCellNum();
				
				data[i-firstRow] = new Object[cellCount];
				
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					Cell c = row.getCell(j);
					data[i-firstRow][j] = getCellValue(c);
				}
				
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw  new RuntimeException(e);
		}
		
		return data;
	}
	public static void main(String[] args) {
		ExcelReader obj = new ExcelReader("C:\\Users\\Vikas\\batch 10\\18Feb2017-DDF\\flipkartsearchexpectedcount.xlsx");
		obj.getData();
	}
	@SuppressWarnings("deprecation")
	private Object getCellValue(Cell c){
		Object value=null;
		if(c.getCellTypeEnum() == CellType.STRING){
			value = c.getStringCellValue();
		}
		else if(c.getCellTypeEnum() == CellType.NUMERIC){
			value = c.getNumericCellValue();
		}
		else if (c.getCellTypeEnum() == CellType.BOOLEAN){
			value= c.getBooleanCellValue();
		}
		else{
			value ="";
		}
		return value;
	}
}
