package sauceDemo.utilities;

import sauceDemo.pageObjects.loginPages;

import org.openqa.selenium.WebDriver;

import sauceDemo.pageObjects.dashboardPages;

public class ContextClass extends driverInitialitator {
	private  loginPages loginPage;
	private  dashboardPages dashboardPage;
	public ContextClass()
	{
		setup();
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	public loginPages getLoginPage()
	{
		if(loginPage==null)
		{
			loginPage = new loginPages(driver);
		}
		return loginPage;
	} 
	
	public dashboardPages getdashBoardPage()
	{
		if(dashboardPage==null)
		{
			dashboardPage = new dashboardPages(driver);
		}
		return dashboardPage;
	} 

}
