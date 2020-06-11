package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class EmployeeReportsPageElements extends CommonMethods {
	
	@FindBy(css="div.head h1")
	public WebElement headerEmpReports;
	@FindBy(id="btnAdd")
	public WebElement addBtn;
	
	@FindBy(id="resultTable")
	public WebElement table;
	
	@FindBy(xpath="//table[@id='resultTable']//tbody/tr")
	public List<WebElement> rowsOfTable;
	
	public EmployeeReportsPageElements() {
		PageFactory.initElements(driver, this);
	}
}
