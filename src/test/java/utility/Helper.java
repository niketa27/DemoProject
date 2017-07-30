package utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String CaptureScreenShots(WebDriver IDriver, String ScreenShotName) throws Exception
	{
		File src= ((TakesScreenshot)IDriver).getScreenshotAs(OutputType.FILE); //Take screenshot and store as file format
		String Destination ="D:\\Selenium\\Maven_ProjectTest\\Screenshots"+ ScreenShotName+System.currentTimeMillis()+".jpeg";
		
		//Copy the  screenshot to desired location using copyFile method
		
		FileUtils.copyFile(src, new File(Destination));
		return Destination;
	}

}
