package com.hrms.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	public static ExtentTest test;               // specify actual results fail/pass

	@BeforeTest(alwaysRun = true)
	public void generateReport() {
		ConfigsReader.readConfigs(Constants.PROPERTIES_FILE_PATH);
		System.out.println("from BaseClass.generateReport()-----------starting generating report----------");
		htmlReport = new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
		htmlReport.config().setDocumentTitle(ConfigsReader.getValueOfProperty("reportName"));
		htmlReport.config().setReportName(ConfigsReader.getValueOfProperty("reportName"));
		htmlReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReport);
	}
	
	@AfterTest(alwaysRun = true)
	public void writeReport() {
		System.out.println("from BaseClass.writeReport()-----------writing generating report----------");
		report.flush();
	}

	/**
	 * Method set up the driver's properties for browser and run the corresponding
	 * browser
	 */
	@BeforeMethod(alwaysRun = true) // to make this method run before every @test method
	public static WebDriver setUpBrowser() {
		switch (ConfigsReader.getValueOfProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", Constants.FIREFOX_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		default:
			throw new RuntimeException("browser is not supported");
		}
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME,
		// TimeUnit.SECONDS);
		driver.get(ConfigsReader.getValueOfProperty("url"));
		PageInitializer.initialize(); // initialize all page objects of setUpBrowser
		return driver;

	}

	/**
	 * Method close the browser session
	 */
	@AfterMethod(alwaysRun = true) // to make this method run after @Test method
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
