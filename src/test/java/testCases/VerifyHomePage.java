package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ApplicationPages.HomePage;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyHomePage {

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
	    driver= BrowserFactory.OpenBrowser("Firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());	  
	}
	
	@Test
	public void OpenHomePage() throws Exception
	{
		HomePage home=PageFactory.initElements(driver,HomePage.class);
		String title = home.getApplicationTitle();
	    Assert.assertTrue(title.contains("Demo"));
	  //  home.redirectToMyCart();
	    Thread.sleep(3000);
       //	System.out.println(title);
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.CloseBrowser(driver);
	}	
}
