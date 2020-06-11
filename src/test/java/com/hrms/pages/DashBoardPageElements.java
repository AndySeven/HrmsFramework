package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashBoardPageElements extends CommonMethods {
	@FindBy(id="welcome")
	public WebElement welcome;
	@FindBy(xpath="//div[@id='branding']/a[1]")
	public WebElement logo;
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']/b")
	public WebElement btnPim;
	@FindBy(id="menu_pim_addEmployee")
	public WebElement btnAddEmp;
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']//b")
	public WebElement pim;
	@FindBy(id="menu_core_viewDefinedPredefinedReports")
	public WebElement reportsBtn;
	
	public DashBoardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateToAddEmp() {
		jsClick(pim);
		jsClick(btnAddEmp);
	}
	
	
}
