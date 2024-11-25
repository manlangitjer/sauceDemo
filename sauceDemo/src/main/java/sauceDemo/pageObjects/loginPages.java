package sauceDemo.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginPages{
	WebDriver driver;
	WebDriverWait wait;
	
	public loginPages(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
			wait = new 	
			WebDriverWait(this.driver,Duration.ofSeconds(1));
		}
	
	public WebElement textFields(String inputName) {
		return driver.findElement(By.xpath("//input[@name='"+inputName+"']"));
	}
	
	public WebElement loginBtn() {
		return driver.findElement(By.xpath("//input[@name='login-button']"));
	}
	
	public WebElement mainDashboardLogo() {
		WebElement element = driver.findElement(By.xpath("//div[@class='app_logo']"));
		return element;
	}
	
	public WebElement lockOutError() {
		return driver.findElement(By.xpath("//*[contains(text(),'Sorry, this user has been locked out.')]"));
	}
	
	public WebElement textElementViaText(String textLabel) {
		return driver.findElement(By.xpath("//*[contains(text(),'"+textLabel+"')]"));
	}
	
	public void inputTextFields(String fieldName, String inputtedValue) {
		this.textFields(fieldName).sendKeys(inputtedValue);
	}
	
	public void clckLogin() {
		this.loginBtn().click();
	}
	
	public void validateLogins(String userName) {
		if(userName=="standard_user") {
			Assert.assertTrue(this.mainDashboardLogo().isDisplayed());
			Assert.assertTrue(this.textElementViaText("Products").isDisplayed());
		}else if(userName=="locked_out_user"){
			Assert.assertTrue(this.lockOutError().isDisplayed());
		}
	}
}
