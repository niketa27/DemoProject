package ApplicationPages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



	public class LoginPage {
		
		WebDriver driver;
		
		public LoginPage(WebDriver Idriver)
		{
			Idriver = driver;
		}
		
		
		@FindBy(xpath=".//*[@id='account_sign_in_form_email_id']")
		WebElement email;
		
		@FindBy(xpath=".//*[@id='account_sign_in_form_passwd_id']")
		WebElement password;
		
		@FindBy(xpath=".//input[@value='Log In']")
		WebElement LOGIN;
		
		@FindBy(xpath="//a[text()=' Dashboard ']//following::div[2]")
		WebElement DashboardTitle;
		
		
		public void LoginToApplication(String name, String pass) throws Exception
		{
			email.sendKeys(name);
			password.sendKeys(pass);
			LOGIN.click();
			Thread.sleep(3000);
		}
		
		public void DashBoardTitleVerification()
		{
		//	WebDriverWait wait = new WebDriverWait(driver,40);
			//WebElement ele = wait.until(ExpectedConditions.visibilityOf(DashboardTitle));
			
				String title = DashboardTitle.getText();
		//	String title= ele.getText();
			System.out.println(title);
			Assert.assertEquals(title,"Account Dashboard View","DashboardTitle Not Verified");
		
			
		}

	}
