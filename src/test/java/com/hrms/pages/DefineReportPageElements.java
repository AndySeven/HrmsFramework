package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class DefineReportPageElements extends CommonMethods {
	@FindBy(css="div.head h1")
	public WebElement DefineReportHeader;
	@FindBy(id="report_report_name")
	public WebElement reportName;
	@FindBy(id="report_criteria_list")
	public WebElement selectionCriteriaDD;
	@FindBy(id="btnAddConstraint")
	public WebElement addSCLink;
	@FindBy(css="li#li_pay_grade > a")
	public WebElement deselectCriteria;
	@FindBy(id="employee_name_empName")
	public WebElement addEmpNameToSearchBox;
	@FindBy(xpath="//label[@for='report_display_groups']//following-sibling::select")
	public WebElement dispFieldGroupsDD;
	@FindBy(id="btnAddDisplayGroup")
	public WebElement addDFGLink; 
	@FindBy(id="report_display_field_list")
	public WebElement dispFieldsDD;
	@FindBy(id="btnAddDisplayField")
	public WebElement addDFLink;
	@FindBy(xpath="//input[@name='display_groups[]']")
	public List<WebElement> dispHeaderGroupsCheckBoxes; // 16
	@FindBy(xpath="//input[@name='display_fields[]']")
	public List<WebElement> dispHeaderFieldsCheckBoxes; // 100
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	@FindBy(xpath="//li[@id='li_include']/following::select[@id='report_include_comparision']")
	public WebElement includeDD;
	
	
	
	public DefineReportPageElements() {
		PageFactory.initElements(driver, this);
	}
}
