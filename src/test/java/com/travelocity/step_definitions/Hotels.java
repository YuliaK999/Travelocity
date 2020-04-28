package com.travelocity.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.travelocity.pages.HotelsPage;
import com.travelocity.utilities.BrowserUtilities;
import com.travelocity.utilities.ConfigReader;
import com.travelocity.utilities.Driver;
import com.travelocity.utilities.LoggerUtils;

public class Hotels {

	Logger logger = LoggerUtils.getLogger(FlightSearchStepDefs.class);

	@Given("I am on the TravelocityCom homepage")
	public void i_am_on_the_TravelocityCom_homepage() {
		Driver.getDriver().get(ConfigReader.getConfiguration("url"));
		logger.info("Navigating to a TravelocityCom homepage");
	}

	@Given("Click on hotels")
	public void click_on_hotels() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking on Hotels");
		hotelspage.hotelsMenu.click();
		BrowserUtilities.waitFor(3);
				
	}

	@Then("The hotels page title should be Cheap Hotels: Book Hotel Deals With Our Hotel Finder | Travelocity")
	public void the_hotels_page_title_should_be_Cheap_Hotels_Book_Hotel_Deals_With_Our_Hotel_Finder_Travelocity() {
		logger.info("Getting the Hotels page title");
		String actual = Driver.getDriver().getTitle();
		String expected = "Cheap Hotels: Book Hotel Deals With Our Hotel Finder | Travelocity";
		logger.info("Verifying the title");

		try {
			assertEquals(expected, actual);
			logger.info("Title Verification passed");

		} catch (AssertionError e) {

			logger.error("Title Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	
	@And("Click on Going to field")
	public void click_on_Going_to_field() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking on Going to field");
		hotelspage.goingToField.click();
		BrowserUtilities.waitFor(3);
	}

	@And("Enter {string} destination")
	public void enter_destination(String destination) {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Entering " + destination + " on Going to field");
		hotelspage.destenationField.sendKeys(destination + Keys.ENTER);
		BrowserUtilities.waitFor(3);
	}

	@Then("Destination field should contain {string}")
	public void destination_field_should_contain(String destination) {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Verifying the field should contains " + destination);
		try {
			assertTrue(destination.contains(hotelspage.goingToField.getText()));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	@And("Click on Check in field")
	public void click_on_Check_in_field() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking on Check in field");
		hotelspage.checkInField.click();
		BrowserUtilities.waitFor(3);
	}

	@And("Set {string} {int} {int} date to Check in field")
	public void set_date_to_Check_in_field(String string, Integer int1, Integer int2) {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Seting " + string+int1+int2 + " on Check in field");
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		js.executeScript("arguments[0].click()", hotelspage.setCheckInDate(string, int1, int2));
		BrowserUtilities.waitFor(3);
		logger.info("Clicking Done button");
		hotelspage.calendarDoneButton.click();
		BrowserUtilities.waitFor(3);
	}

	@Then("Check in field should contain {string} {int}")
	public void check_in_field_should_contain(String string, Integer int1) {
		HotelsPage hotelspage = new HotelsPage();
		String expected = string+int1;
		System.out.println(expected);
	    String actual = hotelspage.checkInField.getText();
	    System.out.println(actual);
	    logger.info("Verifying the Check in field should contains " + string+int1);
		try {
			assertTrue(actual.contains(expected));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	    
	}
	
	
	

}