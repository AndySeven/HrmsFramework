package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "btnSave")
	public WebElement btnSave;

	@FindBy(id = "photofile")
	public WebElement uploadBtn;

	@FindBy(id = "chkLogin")
	public WebElement singleCheckBox;

	@FindBy(id = "user_name")
	public WebElement nickName;
	
	@FindBy(id = "user_password")
	public WebElement userPassword;
	
	@FindBy(id = "re_password")
	public WebElement rePassword;
	
	@FindBy(id = "status")
	public WebElement statusDD;
	
	@FindBy(xpath = "//input[@id='firstName']/following-sibling::span")
	public WebElement errMsgFirstName;
	
	@FindBy(xpath = "//input[@id=\"lastName\"]/following-sibling::span")
	public WebElement errMsgLastName;
	
	@FindBy(id="photofile")
	public WebElement addFile;
	
	@FindBy(css="label.hasTopFieldHelp")
	public WebElement fullNameField;
	
	@FindBy(xpath="//input[@id='employeeId']/preceding-sibling::label")
	public WebElement employeeIdField;
	
	@FindBy(xpath="//input[@id='photofile']/preceding-sibling::label")
	public WebElement photoField;
	
	
	

	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}
	
	public void addFirstAndLastNameAndUploadPhoto(String firstName, String lastName, String photoPath) {
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
		uploadFile(addEmp.uploadBtn, photoPath);
	}
}
