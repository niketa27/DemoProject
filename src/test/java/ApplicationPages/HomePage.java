package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver Idriver)
	{
			driver=Idriver;
	}
	
	@FindBy(xpath="(//span[text()='Home'])[1]")
	WebElement Home;
	
	@FindBy(xpath="(//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//span[text()='My Cart']")
	WebElement myCart;
	
	@FindBy(xpath="//span[text()='Wishlist']")
	WebElement Wishlist;
	
	@FindBy(xpath="//span[text()=' Log In']")
	WebElement logIn;
	
	public void redirectToHomePage()
	{
		Home.click();
	}
	
	public void redirectToMyAccount()
	{
		myAccount.click();
	}
	
	public void redirectToMyCart()
	{
		myCart.click();
	}
	
	public void redirectToWishList()
	{
		Wishlist.click();
	}
	public void LoginApplication()
	{
		logIn.click();
	}
	public String getApplicationTitle()
	{
		String Title=driver.getTitle();
		return Title;
		
	}
}
