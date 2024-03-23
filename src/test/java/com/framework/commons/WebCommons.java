package com.framework.commons;

import com.framework.base.BasePage;
import com.framework.utilities.Constants;
import com.framework.utilities.ReadProp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebCommons {
    public WebDriver driver = new BasePage().getDriver();
    public Properties prop = ReadProp.readData("Config.properties");

    //Method to Launch the application
    public void launchApplication(String url) {
        driver.get(url);
    }

    //Method to click the element
    public void clickElement(WebElement element) {
        element.click();
    }

    //Method to type the text
    public void type(WebElement element, String data) {
        element.clear();
        element.sendKeys(data);
    }

    //Method to select the checkbox
    public void selectCheckBox(WebElement element, Boolean status) {
        boolean isElementSelected = element.isSelected();
        if (isElementSelected != status)
            element.click();

    }

    //Method to implicit wait
    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    //Method to explicit wait
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Method to Select the dropdown
    public void dropDown(WebElement dropdown, String by, String option) {
        Select s = new Select(dropdown);
        if (by.equalsIgnoreCase("visibletext"))
            s.selectByVisibleText(option);
        else if (by.equalsIgnoreCase("value"))
            s.selectByValue(option);
        else if (by.equalsIgnoreCase("index"))
            s.selectByIndex(Integer.valueOf(option));
    }

    //method to wait java
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Method for window screenshot
    public String screenShot(String filename) throws IOException {
        String filepath = System.getProperty("user.dir")+"\\Screenshots\\"+filename+".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(filepath));
        return filepath;
    }
    //Method for element screenshot
    public String screenShot(WebElement element,String filename) throws IOException {
        String filepath = System.getProperty("user.dir")+"\\Screenshots\\"+filename+".png";
        File screenshot = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(filepath));
        return filepath;
    }

    //Method to get text from element
    public String getText(WebElement element) {
       return element.getText();
    }

    //Method to get Attribute value from element
    public String getAttributeValue(WebElement element, String attributeName) {
       return element.getAttribute(attributeName);
    }

    //Method to check whether element is displayed
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    //Method to check whether element is enabled
    public boolean isEnabled(WebElement element) {
      return element.isEnabled();
    }

    //double click
    public void dblClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    //get Title
    public String getTitle() {
       return driver.getTitle();
    }   

}
