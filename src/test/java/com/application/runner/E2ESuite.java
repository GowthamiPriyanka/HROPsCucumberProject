package com.application.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = { "com.application.stepDefinition", "com.framework.base" }, plugin = {
		"pretty", "html:Reports/AutomationReport.html" }, tags="@Regression")


public class E2ESuite {

}
