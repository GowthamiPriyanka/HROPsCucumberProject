package com.application.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.application.steps.HomePageSteps;
import com.application.steps.LoginPageSteps;
import com.framework.base.BasePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {    
	
    public LoginPageSteps loginPage = null;
    public HomePageSteps homePage = null;
    
    @Given("Initialize all pages")
    public void initializePages(){
        WebDriver driver = new BasePage().getDriver();
        loginPage = new LoginPageSteps(driver);
        homePage = new HomePageSteps(driver);
    }
	
	@Given("Launch the application")
	public void launch_the_application() {
		loginPage.launchApplication();	    
	}

	@Then("Verify application logo")
	public void verify_application_logo() {
		loginPage.verifyLogo();	    
	}

	@Then("Verify application login page header is displayed as {string}")
	public void verify_application_login_page_header_is_displayed_as(String string) {
		loginPage.verifyLoginPageHeader(string);	    
	}

	@When("^User enter (.*) and (.*)$")
	public void enterCredentials(String username, String password) {
		loginPage.enterCredentials(username, password);    
	}

	@When("Click on login button")
	public void click_on_login_button() {
		loginPage.clickOnLoginBtn();	    
	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
		homePage.verifyLoginSuccessful();	    
	}

	@Then("Verify dashboard menu items")
	public void verify_dashboard_menu_items() {
		homePage.verifyMenuItemsInDashboardPage();	    
	}

	@Then("Verify logout")
	public void verify_logout() {
		homePage.logoutFromApp();	    
	}

}
