package com.hrms.testcases;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelReader;

public class DefineReportsTest extends CommonMethods {

	@Test(dataProvider = "getReportData", groups = "regression")
	public void defineReports(String reportName, String selCriteria, String empNameForCriteria, String includeDDValue,
			String dispFGDDValue, String field1, String field2, String field3, String dispFGDDValue2) {

		// login to HRMS
		login.login(ConfigsReader.getValueOfProperty("username"), ConfigsReader.getValueOfProperty("password"));

		test.info("Clicking on PIM menu button");
		jsClick(dash.btnPim);

		test.info("Clicking on Reports menu button");
		jsClick(dash.reportsBtn);

		test.info("Validation viewDefinedPredefinedReports page opened");
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(waitForVisibility(empRep.headerEmpReports).isDisplayed(),
				"Header Employee Reports is NOT Dislayed");

		test.info("Clicking on Add button");
		click(empRep.addBtn);

		test.info("Validation DefinePredefinedReport page opened");
		soft.assertTrue(waitForVisibility(defRep.DefineReportHeader).isDisplayed(),
				"Header Define Report is NOT Displayed");

		test.info("Sending name of report to Report Name* text box");
		sendText(defRep.reportName, reportName);

		test.info("Selecting option at Selecting Criteria DD ");
		selectDDValue(defRep.selectionCriteriaDD, selCriteria);

		test.info("Clicking Add link that is related to Selection creteria DD ");
		click(defRep.addSCLink);

		if (selCriteria.equals("Pay Grade")) {
			test.info("IF DON'T USE Selected Criteria (Pay Grade): deleting selected criteria");
			click(defRep.deselectCriteria);
		} else if (selCriteria.equals("Employee Name")) {
			test.info("IF USE Selcted Critetia (Employee Name): add name to the text box Employee Name");
			sendText(defRep.addEmpNameToSearchBox, empNameForCriteria);
			defRep.addEmpNameToSearchBox.sendKeys(Keys.ENTER);
		} else {
			soft.assertTrue(false, "Error in selecting Criteria section");
		}

		test.info("Selecting option at Iclude* DD ");
		selectDDValue(defRep.includeDD, includeDDValue);

		test.info("Selecting option at Display Field Groups DD");
		System.out.println(dispFGDDValue);
		selectDDValue(defRep.dispFieldGroupsDD, dispFGDDValue);

		test.info("Selecting options at Display Fields DD");
		String[] arrDispFields = { field1, field2, field3 };
		for (String f : arrDispFields) {
			selectDDValue(defRep.dispFieldsDD, f);
			test.info("Clicking Add link that is related to Dysplay Fields DD ");
			click(defRep.addDFLink);
		}

		test.info("Again Selecting option at Display Field Groups DD ");
		selectDDValue(defRep.dispFieldGroupsDD, dispFGDDValue2);

		test.info("Clicking Add link that is related to Dysplay Field Groups DD ");
		click(defRep.addDFGLink);

		test.info("select single check box/boxes, to include headers");
		List<WebElement> listCheckHeaderSingleBoxes = defRep.dispHeaderGroupsCheckBoxes;
		for (WebElement header : listCheckHeaderSingleBoxes) {
			String value = header.getAttribute("value");
			if ((value.equals("1") || value.equals("2") || value.equals("7") || value.equals("12"))
					&& header.isDisplayed()) {
				click(header);
			}
		}

		test.info("clicking on save button");
		click(defRep.btnSave);
		soft.assertTrue(waitForVisibility(empRep.headerEmpReports).isDisplayed(),
				"Header Employee Reports is NOT Dislayed");

		test.info("validation of presence created reports on the viewDefinedPredefinedReports page");
		soft.assertTrue(presenseTextInTable(reportName), "report was not found");

		soft.assertAll();
	}

	@DataProvider
	public Object[][] getReportData() {
		return ExcelReader.excelIntroArray(Constants.TESTDATA_FILEPATH, "Reports");
	}

}
