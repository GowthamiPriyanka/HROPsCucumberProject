package com.framework.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.framework.utilities.ReadProp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BasePage {
	public static WebDriver driver = null;

	@Before
	public void setUpBrowser() {
		String browser = ReadProp.readData("Config.properties").getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@After(order = 1)
	public void failedTestListener(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(file);
			scenario.attach(fileContent, "image/png", "ReferScreenshot");
		}
	}

	@After(order = 0)
	public void tearDownBrowser() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
