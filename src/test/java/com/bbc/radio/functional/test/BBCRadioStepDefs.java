package com.bbc.radio.functional.test;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Step definition implementation of radio nav feature files
 *
 * @author Khushboo Taneja
 */
public class BBCRadioStepDefs extends AbstractTestNGCucumberTests{
	
	public static String browserType;
	
	/** The driver. */
	public WebDriver driver;

	/** The section element. */
	private WebElement sectionElement;
	
	// Passing Browser parameter from TestNG xml
	@Before
	public void beforeTest() {
		
		//Default Firefox driver
		if (null == browserType || browserType.equalsIgnoreCase("firefox")) {
			System.out.println("*************** Firefox ***********");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} else if (browserType.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();

		} else if (browserType.equalsIgnoreCase("chrome")) {
			System.out.println("*************** chrome ***********");
			
			driver = new ChromeDriver();
			
			//Having issue in maximize. Issue fixed in chromDriver29.0 version, but 29.0 have another issue
//			driver.manage().window().maximize();

		}

	}
	
	/**
	 * Create FirefoxDriver session, open "http://www.bbc.co.uk/radio" and
	 * maximize the window
	 * 
	 * @throws Throwable
	 *             the throwable
	 */
	@Given("^I can see the radio nav$")
	public void i_can_see_the_radio_nav() throws Throwable {
		driver.get("http://www.bbc.co.uk/radio");
		Thread.sleep(2000);
	}

	/**
	 * Select section from Radionav
	 * 
	 * @param section
	 *            the section
	 * @throws Throwable
	 *             the throwable
	 */
	@When("^I select (.+) in the radio nav$")
	public void i_select_in_the_radio_nav(String section) throws Throwable {
		sectionElement = driver.findElement(By.xpath("//a[contains(text(),'" + section + "')]"));
		sectionElement.click();
		Thread.sleep(2000);
	}

	/**
	 * Verify the drawer is open
	 * 
	 * @param section
	 *            the section
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^the (.+) drawer is open$")
	public void the_drawer_is_open(String section) throws Throwable {
		//Section name starts with Capital letter in feature file, so converting in lower case to match with id 
		WebElement panel = driver.findElement(By.xpath("//div[@id='" + section.toLowerCase() + "-panel']/ul"));
		Assert.assertNotNull(panel);
		Thread.sleep(3000);
	}

	/**
	 * Select section again from Radionav
	 * 
	 * @param section
	 *            the section
	 * @throws Throwable
	 *             the throwable
	 */
	@When("^I select (.+) in the radio nav again$")
	public void i_select_in_the_radio_nav_again(String section) throws Throwable {
		sectionElement.click();
	}

	/**
	 * Verify the panel is closed
	 * 
	 * @param section
	 *            the section
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^the (.+) drawer is closed$")
	public void the_drawer_is_closed(String section) throws Throwable {
		List<WebElement> panel = driver.findElements(By.xpath("//div[@id='" + section + "']/ul"));
		
		Assert.assertTrue(panel.size() == 0);
		
		//Close the browser after verification
		driver.close();
	}

	/**
	 * Verify only one drawer is panel is open and other drawers are closed
	 * 
	 * @param section
	 *            the section
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^the (.+) drawer is open and the other drawers are closed$")
	public void the_drawer_is_open_and_the_other_drawers_are_closed(String section) throws Throwable {
		WebElement sectionElement = driver.findElement(By.xpath("//a[contains(text(),'" + section + "')]"));
		sectionElement.click();
		
		//Checking the displayed status of section
		boolean isStationDisplayed = driver.findElement(By.xpath("//div[@id='stations-panel']/ul")).isDisplayed();

		boolean isCategoriesDisplayed = driver.findElement(By.xpath("//div[@id='categories-panel']/ul")).isDisplayed();

		boolean isSchedulesDisplayed = driver.findElement(By.xpath("//div[@id='schedules-panel']/ul")).isDisplayed();

		boolean result = false;
		
		//Verifying only one drawer is open and others drawers are closed
		if (section.equalsIgnoreCase("Stations")) {
			result = (isStationDisplayed && !isCategoriesDisplayed && !isSchedulesDisplayed);
		} else if (section.equalsIgnoreCase("Categories")) {
			result = (!isStationDisplayed && isCategoriesDisplayed && !isSchedulesDisplayed);
		} else if (section.equalsIgnoreCase("Schedules")) {
			result = (!isStationDisplayed && !isCategoriesDisplayed && isSchedulesDisplayed);
		}

		Assert.assertTrue(result);
		
		//Close the browser after verification
		driver.close();
	}

	/**
	 * 
	 * Verify list of category available in Categories drawer
	 * 
	 * @param dataTable
	 *            the data table
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^I can see the following categories$")
	public void i_can_see_the_following_categories(DataTable dataTable) throws Throwable {
		WebElement categoryPanel = driver.findElement(By.xpath("//div[@id='categories-panel']/ul"));

		List<String> expectedAsList = dataTable.asList(String.class);

		for (String categoryName : expectedAsList) {
			WebElement categoryWebElement = categoryPanel.findElement(By.xpath(".//a[text()='" + categoryName + "']"));

			Assert.assertEquals(categoryName, categoryWebElement.getText());

		}
		//Close the browser after verification
		driver.close();
	}

	/**
	 * Click on AllCategories link in Categories drawer
	 * 
	 * @throws Throwable
	 *             the throwable
	 */
	@And("^I select the all categories link$")
	public void i_select_the_all_categories_link() throws Throwable {
		WebElement allCategories = driver.findElement(By.xpath("//a[text()='All Categories']"));
		allCategories.click();
		Thread.sleep(3000);
	}

	/**
	 *
	 * Verify i am on the AllCategories page
	 * 
	 * @throws Throwable
	 *             the throwable
	 */
	@Then("^I am on the all categories page$")
	public void i_am_on_the_all_categories_page() throws Throwable {
		WebElement categoriesPage = driver.findElement(By.xpath("//*[@id='programmes-main-content']/h1"));
		Assert.assertEquals("http://www.bbc.co.uk/radio/programmes/genres", driver.getCurrentUrl());
		Assert.assertEquals("Categories: Genres", categoriesPage.getText());
		
		//Close the browser after verification
		driver.close();
	}

}