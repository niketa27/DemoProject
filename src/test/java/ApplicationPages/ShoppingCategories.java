package ApplicationPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCategories {
	
	WebDriver driver;
	public ShoppingCategories(WebDriver Idriver)
	{
		driver= Idriver;
	}
	
	@FindBy(xpath="//*[@class='menu-heading menuHeadingdropdown']")
	WebElement Categories;
	 
	@FindBy(xpath="//a[@href='http://fashiontrend.myavactis.com/product-list.php?Women-pg1-cid35.html']")
	WebElement Women;
	
	@FindBy(xpath="//*[contains(@title, 'Dresses')]")
	WebElement Dresses;
	
	@FindBy(xpath=".//*[@id='ProductForm_182']/div/div[2]/div[3]/a")
	WebElement product;
	
	
	@FindBy(xpath="//select[@name='po[191]']")
	WebElement Size;
	
	@FindBy(xpath=".//button[@class='btn btn-addtocart']")
	WebElement AddToCard;
	
	
	public void CategoriesForWomen() throws Exception
	{
		Actions act = new Actions(driver);
		act.moveToElement(Categories).moveToElement(Women).moveToElement(Dresses).click().build().perform();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,250)");
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(product));
		act.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
	
	
	
	}
	
	public void HandleProductDetailsWindow() throws Exception
	{
		String Parent = driver.getWindowHandle();
		System.out.println("Parent ID: "+Parent);
		Set<String> S1 = driver.getWindowHandles();
		Iterator<String> Itr = S1.iterator();
		
		while(Itr.hasNext())
		{
			String child_window = Itr.next();
			
			if(!Parent.equals(child_window))
			{
				{
					System.out.println("Child Window ID: "+child_window);
					driver.switchTo().window(child_window);
					 
					System.out.println(driver.switchTo().window(child_window).getTitle());
					Select sel = new Select(Size);
					sel.selectByValue("447");
					AddToCard.click();
					Thread.sleep(4000);
				}
			}
		
		}
		driver.switchTo().window(Parent);
	}
}

