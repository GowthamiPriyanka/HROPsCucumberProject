package com.application.elements;

import com.framework.commons.WebCommons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements extends WebCommons {

    @FindBy(xpath = "//img[@alt='company-branding']")
    protected WebElement logo;

    @FindBy(xpath = "//h5")
    protected WebElement header;

    @FindBy(xpath = "//input[@name='username']")
    protected WebElement usernameTxtb;

    @FindBy(xpath = "//input[@name='password']")
    protected WebElement passwordTxtb;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement loginBtn;

    @FindBy(xpath = "//p[text()='Forgot your password? ']")
    protected WebElement forgotPassLink;


}
