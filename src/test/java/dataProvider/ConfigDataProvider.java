package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() 
	{
		try{
			
		File src = new File("./Configuration/config.properties");
		FileInputStream InS = new FileInputStream(src);
		pro = new Properties();
		pro.load(InS);
			}
		catch(Exception e)
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}
	
	public String getChromePath()
	{
		String Path = pro.getProperty("ChromeDriver");
		return Path;
	}
	
	public String getApplicationURL()
	{
		String url= pro.getProperty("URL");
		return url;
	}
}
