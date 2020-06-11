package com.hrms.testcases;

import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelReader;
import com.hrms.utils.ExcelReaderMine;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;



public class AddEmployeeTest extends CommonMethods {

	@Test(dataProvider = "userDataFromExcell")
	public void add5Emp(String FN, String LN, String UN, String P) {
		// adding log to extent report html
		test.info("Login to HRMS");
		
		// Login application
		login.login(ConfigsReader.getValueOfProperty("username"),
				ConfigsReader.getValueOfProperty("password"));

		test.info("Navigating to Add Employee Page");
	
		// navigate to AddEmployee Page
		jsClick(dash.pim);
		jsClick(dash.btnAddEmp);

		test.info("Filling out Text Fields: First Name and Last Name");
		// adding first and last name
		sendText(addEmp.firstName, FN);
		sendText(addEmp.lastName, LN);

		test.info("clicking single check box for accessing further credendials fields ");
		// clicking on single check Box
		clickSingleCheckBox(addEmp.singleCheckBox);

		test.info("putting credentials data");
		sendText(addEmp.nickName, UN);
		sendText(addEmp.userPassword, P);
		sendText(addEmp.rePassword, P);
		
		test.info("clicking on save button");
		click(addEmp.btnSave);

		test.info("Validating Proper Adding new Employee");
		String expectedFullName = FN + " " + LN;
		WebElement el = waitForVisibility(pDetails.fullNameHeader);
		String actualFullName = el.getText();
		Assert.assertEquals(actualFullName, expectedFullName, "Header doesn't contain user Full Name");

		// computing number of photo and making a screenshot
		// getScrShot("HRMS", FN+""+LN);

	}

	@DataProvider
	public Object[][] getFromArray() {
		Object[][] data = new Object[2][4];
		data[0][0] = "Bobby";
		data[0][1] = "Jackson";
		data[0][2] = "clodud172";
		data[0][3] = "Asasd$asdasd98w98gg";
		data[1][0] = "Michael";
		data[1][1] = "Brady";
		data[1][2] = "clodud172";
		data[1][3] = "Asasd$asddasd9898gg";
		return data;
	}

	@DataProvider(name = "userDataFromExcell")
	public Object[][] getdata2() {
		return ExcelReader.excelIntroArray(Constants.TESTDATA_FILEPATH, "Sheet1");
	}

	@DataProvider(name = "myDataGenerator")
	public Object[][] dataGenerator() {
		Sheet sheet = ExcelReaderMine.getSheet(Constants.TESTDATA_FILEPATH, "Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows - 1][cols];
		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				data[r - 1][c] = sheet.getRow(r).getCell(c).toString();
			}
		}
		return data;
	}

}
