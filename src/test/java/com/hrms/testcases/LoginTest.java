
package com.hrms.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.ConfigsReader;

public class LoginTest extends com.hrms.utils.CommonMethods {

	@Test(groups="smoke")
	public void validAdminLogin() {
		// LoginPageElements login = new LoginPageElements();
		test.info("Put Valid Credentials to Login");
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		click(login.loginBtn);

		test.info("Verifying Welcome Admin Sign has been appeared");
		String expectedUser = "Welcome Admin";
		String actualUser = dash.welcome.getText();
		
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getValueOfProperty("username")));
		
		
	}

	@Test(groups="regression")
	public void invalidPasswordLogin() {
		test.info("putting invalid password and valid username");
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.loginBtn);
		
		test.info("validating error message has been appeared");
		String expected = "Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}

	@Test(groups="regression")
	public void emptyUsernameLogin() {
		test.info("adding pasword but leaving username box empty");
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		click(login.loginBtn);

		test.info("validating error message has been appeared");
		String expected = "Username cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	
	@Test
	public void timeStamp() {
		Date d = new Date();
		System.out.println(d.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		System.out.println(sdf.format(d.getTime()));
	}

}
