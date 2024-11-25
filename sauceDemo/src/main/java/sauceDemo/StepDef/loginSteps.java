package sauceDemo.StepDef;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import sauceDemo.pageObjects.loginPages;
import sauceDemo.utilities.ContextClass;


public class loginSteps{
	public WebDriver driver;
	loginPages loginPg;
	ContextClass contextClass;
	
	public loginSteps(ContextClass contextClass) {
		this.contextClass = contextClass;
		loginPg = contextClass.getLoginPage();
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page()throws Throwable{
		contextClass.openBaseURL();
	}

	@When("user enters the credential for {string}")
	public void user_enters_the_credential_for(String userName)throws Throwable {	
		loginPg.inputTextFields("user-name", userName);
		loginPg.inputTextFields("password", "secret_sauce");
	}

	@And("user clicks the login button")
	public void user_clicks_the_login_button()throws Throwable {
		loginPg.clckLogin();
	}
	
	@Then("The system should be displayed properly using {string}")
	public void validateScreenAfterlogin(String userName)throws Throwable {
		loginPg.validateLogins(userName);
	    
	}
	
	@And("Close the browser")
	public void user_close_the_browser()throws Throwable {
		contextClass.tearDown();
	}
}
