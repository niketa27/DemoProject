package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.Helper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyLoginPage2 {
	
	  
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
		
		report = new ExtentReports("./Reports/LoginPageReport.html",true);
		
		logger = report.startTest("Verify Login Page");
		
		driver = BrowserFactory.OpenBrowser("Firefox");
		
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testLoginPage() throws Exception{
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis Demo Store"));
		
		logger.log(LogStatus.PASS, "Home Page loaded and verified");
		
		
		home.redirectToLoginPage();
	//	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.CaptureScreenShots(driver, "Login1")));
		
		logger.log(LogStatus.INFO, "Click on Login link");
		
		LoginPage login = PageFactory.initElements(driver, 

LoginPage.class);
		
		login.LoginToApplication(DataProviderFactory.getExcel().getData(0, 1, 0),DataProviderFactory.getExcel().getData(0, 1, 1));
	
		logger.log(LogStatus.INFO,"Login information");
		
		login.DashBoardTitleVerification();
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.CaptureScreenShots(driver, "Validation2")));
		
		logger.log(LogStatus.PASS, "Dashboard Title verified.");
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception{
		
		if(result.getStatus()==ITestResult.FAILURE){
			String path= Helper.CaptureScreenShots(driver, 

result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		
		BrowserFactory.CloseBrowser(driver);
		
		report.endTest(logger);
		report.flush();
	}
	

}
