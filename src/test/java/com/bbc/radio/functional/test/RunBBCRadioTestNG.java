package com.bbc.radio.functional.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        format = {"pretty", "json:target/cucumber-json"},
        features = "classpath:functional",
        glue = {"com.bbc.radio.functional.test"}
)
public class RunBBCRadioTestNG extends AbstractTestNGCucumberTests{

	@Parameters("browser")
	@BeforeClass
	// Passing Browser parameter from TestNG xml
	public void beforeTest(String browser) {

		BBCRadioStepDefs.browserType = browser;

	}
	
}
