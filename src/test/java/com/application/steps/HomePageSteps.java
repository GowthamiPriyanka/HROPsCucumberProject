package com.application.steps;

import com.application.elements.HomePageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageSteps extends HomePageElements {

    public HomePageSteps(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void verifyLoginSuccessful(){
        waitForElement(dashboardHeader);
    }

    public void verifyProfilePage(){
        waitForElement(userProfileImage);
    }

    public void verifyMenuItemsInDashboardPage(){
        waitForElement(admin);
        waitForElement(pim);
        waitForElement(leave);
        waitForElement(leave);
        waitForElement(recruitment);
        waitForElement(myInfo);
    }

    public void logoutFromApp(){
        clickElement(userProfileOptions);
        waitForElement(logout);
        clickElement(logout);
    }

}
