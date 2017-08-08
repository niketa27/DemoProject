package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyLoginPage {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
	    driver= BrowserFactory.OpenBrowser("Firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());	  
	}
	
	@Test
	public void OpenLoginPage() throws Exception
	{
		HomePage home=PageFactory.initElements(driver,HomePage.class);
	    home.redirectToLoginPage();
	    Thread.sleep(3000);
	    LoginPage Login = PageFactory.initElements(driver,LoginPage.class);
	  //  Login.LoginToApplication("zope.niketa@gmail.com", "niketa123");
	 // Login.LoginToApplication(DataProviderFactory.getExcel().getData(0, 1, 0), DataProviderFactory.getExcel().getData(0, 1, 1));
	  //Login.DashBoardTitleVerification();
	
	 // Login.LoginToApplication(DataProviderFactory.getExcel().getData(0, i, j), DataProviderFactory.getExcel().getData(0, i, j));
	 
	for(int i=1;i<9;i++)
	{
		for(int j=0;j<2;j++)
		{
		String Name = DataProviderFactory.getExcel().getData(0, i, j);
		
		System.out.println(Name);

		}
		
	}
	
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.CloseBrowser(driver);
	}	

}
