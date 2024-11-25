package sauceDemo.StepDef;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import sauceDemo.pageObjects.dashboardPages;
import sauceDemo.utilities.ContextClass;

public class dashboardSteps{
	public WebDriver driver;
	dashboardPages dashBoard;
	ContextClass contextClass;
	
	public dashboardSteps(ContextClass contextClass) {
		this.contextClass = contextClass;
		dashBoard = contextClass.getdashBoardPage();
	}
	
	@And("user sorts the products by {string}")
	public void sortProds(String optionName)throws Throwable {
		dashBoard.sortProducts(optionName);
	}
	
	@Then("the selected products should be displayed properly")
	public void validateProdCart()throws Throwable {
		dashBoard.validateSelectedProducts();
	}
	
	@And("user select products with {string} price")
	public void selectsProductByPrice(String prodPrice)throws Throwable {
		dashBoard.selectsProdsByPrice(prodPrice);
	}
	
	@And("user clicks the Cart button")
	public void clickCart()throws Throwable {
		dashBoard.clickCartButton();
	}
	
	@Then("The products should be sorted by {string}")
	public void validateProductSorting(String optionName)throws Throwable {
		dashBoard.validateSorting(optionName);
	}
	
	@And("user clicks the Checkout button")
	public void clickCheckout()throws Throwable {
		dashBoard.clickCheckoutButton();
	}
	
	@And("user clicks the Continue button")
	public void clickContinue()throws Throwable {
		dashBoard.clicinfoContinueButton();
	}
	
	@And("user fills out the information form")
	public void fillInfoForm()throws Throwable {
		dashBoard.inputTextFields("firstName", "test firstname");
		dashBoard.inputTextFields("lastName", "test lastname");
		dashBoard.inputTextFields("postalCode", "1234");
	}

}
