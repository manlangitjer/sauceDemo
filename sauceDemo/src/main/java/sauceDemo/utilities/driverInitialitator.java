package sauceDemo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

public class driverInitialitator {
	
	public WebDriver driver;
	
	public void setup()
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				path+"/Drivers/chromedriver.exe");
		if(driver==null)
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}
	
	public void openBaseURL()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}