package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReaderMine {
	public static Sheet sheet;

	public static Sheet getSheet(String excelPath, String sheetName) {

		try {
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook book = new XSSFWorkbook(fis);
			sheet = book.getSheet(sheetName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheet;
	}

	public static String getSingleValueFromExcel(String excelPath, String sheetName, String key) {
		Sheet sheet = getSheet(excelPath, sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		Map<String, String> map = new LinkedHashMap<>();
		// for(int r=0; r<rows; r++) {
		for (int c = 0; c < cols; c++) {
			String k = sheet.getRow(0).getCell(c).toString();
			String v = sheet.getRow(1).getCell(c).toString();
			map.put(k, v);
		}
		return map.get(key);
	}
	
	
}
