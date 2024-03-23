package com.application.steps;

import com.application.elements.LoginPageElements;
import com.framework.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageSteps extends LoginPageElements {

    public LoginPageSteps(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void launchApplication(){
        driver.get(prop.getProperty("url"));
    }
    public void verifyLogo(){
        waitForElement(logo);
        Assert.assertTrue(isDisplayed(logo));
    }

    public void verifyLoginPageHeader(String expectedHeader){
        waitForElement(header);
        Assert.assertEquals(getText(header),expectedHeader);
    }

    public void enterCredentials(String username, String password){
        waitForElement(usernameTxtb);
        type(usernameTxtb,username);
        type(passwordTxtb,password);
    }
    
    public void clickOnLoginBtn(){
        clickElement(loginBtn);
    }

}
