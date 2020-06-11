package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {

	// Nationality Drop Down
	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;
	// Gender Radio Buttons
	@FindBy(name = "personal[optGender]")
	public List<WebElement> nationality;
	
	@FindBy(xpath="//div[@id='profile-pic']//h1")
	public WebElement fullNameHeader;
	
	@FindBy(id="empPic")
	public WebElement photo;

	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logout;
	
	// Initializing all elements at once
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
