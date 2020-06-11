package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static FileInputStream fis;
	private static Workbook book;
	private static Sheet sheet;

	public static void readExcel(String filePath) {
		try {
			fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Sheet getSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
		return sheet;
	}

	public static int getNumberRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int getNumberCols(int row) {
		return sheet.getRow(row).getLastCellNum();
	}

	public static Object[][] getExcelData(String filePath, String sheetName) {
		readExcel(filePath);
		getSheet(sheetName);
		int rows = getNumberRows();
		int cols = getNumberCols(0);
		Object[][] data = new Object[rows - 1][cols];
		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				data[r - 1][c] = sheet.getRow(r).getCell(c).toString();
			}
		}
		return data;
	}

}
