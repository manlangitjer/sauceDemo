package sauceDemo.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sauceDemo.utilities.actionHelper;

public class dashboardPages{
	actionHelper helpers = new actionHelper();
	WebDriver driver;
	WebDriverWait wait;
	
	public static List <String> gettedString = new ArrayList<String>();
	public static List <String> orderList = new ArrayList<String>();
	public static List <Double> dblSortedValues = new ArrayList<Double>();
	
	public dashboardPages(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
			wait = new 	
			WebDriverWait(this.driver,Duration.ofSeconds(1));
	}
	
	public WebElement cartButton() {
		return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	}

	public WebElement sortButton() {
		return driver.findElement(By.xpath("//*[@class='product_sort_container']"));
	}
	
	public WebElement textFields(String inputName) {
		return driver.findElement(By.xpath("//input[@name='"+inputName+"']"));
	}
	
	public WebElement checkoutButton() {
		return driver.findElement(By.xpath("//button[@id='checkout']"));
	}
	
	public WebElement infoContinueButton() {
		return driver.findElement(By.xpath("//input[@id='continue']"));
	}
	
	public WebElement textElementViaText(String textLabel) {
		return driver.findElement(By.xpath("//*[contains(text(),'"+textLabel+"')]"));
	}
	
	public List<WebElement> addtoCartByPrice(String productPrice) {
		List<WebElement>  element = new ArrayList<>();
		element = driver.findElements(By.xpath("//*[text()='"+productPrice+"']/following::button[1]"));
		return element;
	}
	
	public List<WebElement> orderListName(String productPrice) {
		List<WebElement>  element = new ArrayList<>();
		element = driver.findElements(By.xpath("//div[text()='"+productPrice+"']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_name '][1]"));
		return element;
	}
	
	public List<WebElement> getProductPrices(){
		List<WebElement>  element = new ArrayList<>();
		element = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		return element;
	}
	
	public void validateSorting(String sortOrder) {
		if(sortOrder.equals("Price (high to low)")) {
			gettedString = helpers.convertWebElementtoText(getProductPrices());
			dblSortedValues = helpers.sortNumberswithDec(gettedString, "Descending");
		}
		for(int i=0; i<dblSortedValues.size(); i++) {
			Assert.assertTrue(gettedString.get(i).contains(String.valueOf(dblSortedValues.get(i))));
		}
	}
	
	public void sortProducts(String sortOptions) {
		this.sortButton().click();
		this.textElementViaText(sortOptions).click();
	}
	
	public void selectsProdsByPrice(String productPrice) {
		orderList = helpers.convertWebElementtoText(orderListName(productPrice));
		for(int i=0; i<this.addtoCartByPrice(productPrice).size(); i++) {
			this.addtoCartByPrice(productPrice).get(i).click();
		}
	}
	
	public void validateSelectedProducts() {
		for(int i=0; i<orderList.size(); i++) {
			Assert.assertTrue(this.textElementViaText(orderList.get(i)).isDisplayed());
		}
		orderList.clear();
	}
	
	public void clickCartButton() {
		this.cartButton().click();
	}
	
	public void clickCheckoutButton() {
		this.checkoutButton().click();
	}
	
	public void clicinfoContinueButton() {
		this.infoContinueButton().click();
	}
	
	public void inputTextFields(String fieldName, String inputtedValue) {
		this.textFields(fieldName).sendKeys(inputtedValue);
	}
}
