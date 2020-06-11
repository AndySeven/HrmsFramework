package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
	private static Workbook book;
	private static Sheet sheet;

	public static void openExcel(String filePath) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Sheet loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
		return sheet;
	}

	public static int rowsCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int colsCount(int row) {
		return sheet.getRow(row).getLastCellNum();
	}
	
	public static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	public static Object[][] excelIntroArray(String filePath, String sheetName){
		openExcel(filePath);
		loadSheet(sheetName);
		
		int rows = rowsCount();
		int cols = colsCount(0);
		
		Object[][] data = new Object[rows-1][cols];
		for (int r = 1; r < rows; r++) {
			for(int c =0; c < cols; c++){
				data[r-1][c] = cellData(r, c);
			}
		}
		return data;
	}
	@DataProvider(name = "userDataFromExcell")
	public Object[][] getdata2(){
		return ExcelReader.excelIntroArray(System.getProperty("user.dir")+"/data/DataProvider.xlsx", "Sheet1");
	}
}
