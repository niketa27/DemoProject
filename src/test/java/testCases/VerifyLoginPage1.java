package testCases;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyLoginPage1 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeMethod
	public void setUp()
	{
		report=new ExtentReports("./Reports/LoginPageReport.html", true);
		logger = report.startTest("Verify Login Page");
	    driver= BrowserFactory.OpenBrowser("Firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());	  
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void OpenLoginPage() throws Exception
	{
		HomePage home=PageFactory.initElements(driver,HomePage.class);
	    String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("Avactis Demo Store"));
	
		logger.log(LogStatus.PASS,"Home Page Loaded and Verified Title for page");
		 home.redirectToLoginPage();
		 
		 logger.log(LogStatus.INFO, "Click on Login Page");
	    Thread.sleep(3000);
	    LoginPage Login = PageFactory.initElements(driver,LoginPage.class);
	  //  Login.LoginToApplication("zope.niketa@gmail.com", "niketa123");
	  Login.LoginToApplication(DataProviderFactory.getExcel().getData(0, 1, 0), DataProviderFactory.getExcel().getData(0, 1, 1));
	  
	  logger.log(LogStatus.INFO,"Login Information");
	  Login.DashBoardTitleVerification();
	  logger.log(LogStatus.PASS,"Login and verified title");
	  
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.CloseBrowser(driver);
		report.endTest(logger);
		report.flush();
	}	

}

