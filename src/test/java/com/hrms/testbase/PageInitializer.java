package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashBoardPageElements;
import com.hrms.pages.DefineReportPageElements;
import com.hrms.pages.EmployeeReportsPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

/**
 * Method initialize all page classes and store ref in static var
 * that will called/used in that classes
 *
 */
public class PageInitializer extends BaseClass {
	public static LoginPageElements login;
	public static DashBoardPageElements dash;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pDetails;
	public static EmployeeReportsPageElements empRep;
	public static DefineReportPageElements defRep;

	public static void initialize() {
		login = new LoginPageElements();
		dash = new DashBoardPageElements();
		addEmp = new AddEmployeePageElements();
		pDetails = new PersonalDetailsPageElements();
		empRep = new EmployeeReportsPageElements();
		defRep = new DefineReportPageElements();
	}
}
