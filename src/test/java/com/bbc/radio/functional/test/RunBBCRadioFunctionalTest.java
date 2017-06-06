/**
 * 
 */
package com.bbc.radio.functional.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The Class RunBBCRadioFunctionalTest.
 *
 * @author Khushboo Taneja
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber-json"},
        features = "classpath:functional",
        glue = {"com.bbc.radio.functional.test"}
)

public class RunBBCRadioFunctionalTest {
	
	/*@BeforeClass
	public void driverSetup(){
		
		BBCRadioStepDefs.driver = new FirefoxDriver();
		
	}*/

}