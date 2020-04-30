package com.travelocity.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.travelocity.pages.FlightsPage;
import com.travelocity.step_definitions.FlightSearchStepDefs;
import com.travelocity.utilities.LoggerUtils;
import java.util.List;
import org.apache.log4j.Logger;
import com.travelocity.utilities.BrowserUtilities;
import com.travelocity.utilities.ConfigReader;
import com.travelocity.utilities.Driver;

public class FlightSearchStepDefs {
	public static String keyword;
	
	Logger logger = LoggerUtils.getLogger(FlightSearchStepDefs.class);
	
	@Given("I am on the flights page")
	public void i_am_on_the_flights_page() {
		FlightsPage flightsPage = new FlightsPage();
		Driver.getDriver().get(ConfigReader.getConfiguration("url"));
		Driver.getDriver().manage().window().maximize();
		logger.info("Navigating to flights page");
		flightsPage.flightsButton.click();
	}
	
	@When("I click on Hotels button")
	public void i_click_on_Hotels_button() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.hotelsButton.click();
	}	

	@When("I click on Flights button")
	public void i_click_on_flights_button() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.flightsButton.click();
	}

	@Then("I should land on flights page")
	public void i_should_land_on_flights_page() {
		FlightsPage flightsPage = new FlightsPage();
		//String actualColor = flightsPage.flightsButton.getCssValue("background-color");
		//Assert.assertEquals("rgb(0,78,147)", actualColor);
		Assert.assertTrue(flightsPage.flightsText.getText().contains("Flights"));
	}
	
	@When("I type a keyword into Flying from field")
	public void i_type_a_keyword_into_Flying_from_field() {
		FlightsPage flightsPage = new FlightsPage();
		keyword = flightsPage.generateKeyword();
		flightsPage.flyingFromAirport.sendKeys(keyword);
	}

	@Then("I should see suggested options in the dropdown")
	public void i_should_see_suggested_options_in_the_dropdown() {
		FlightsPage flightsPage = new FlightsPage();
		List<String> options = BrowserUtilities.getElementsText(flightsPage.options);
		String[] letters = keyword.split("");
		for (String option : options) {
			for (String letter : letters) {
			Assert.assertTrue(option.contains(letter));
			}
		}
	}
	
	@When("I click on Clear button")
	public void i_click_on_Clear_button() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.clearButton.click();
	}

	@Then("Flying from field should get cleared")
	public void flying_from_field_should_get_cleared() {
		FlightsPage flightsPage = new FlightsPage();
	    Assert.assertEquals(flightsPage.flyingFromAirport.getText(),"");
	}
	
	@When("I click on Search button")
	public void i_click_on_Search_button() {
		FlightsPage flightsPage = new FlightsPage();
		BrowserUtilities.waitForClickablility(flightsPage.searchButton, 10);;
		flightsPage.searchButton.click();
	}

	@Then("Error messages should be displayed")
	public void error_messages_should_be_displayed() {
		FlightsPage flightsPage = new FlightsPage();
		Assert.assertEquals("Please correct the errors below.",flightsPage.errorMessage.getText());
	}
	
	@When("I enter flight details")
	public void i_enter_flight_details() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.flyingFromAirport.click();
		flightsPage.flyingFromAirport.sendKeys("Istanbul");
		BrowserUtilities.selectFromList(flightsPage.airportList, "Istanbul (IST - All Airports)");
		flightsPage.flyingToAirport.click();
		flightsPage.flyingToAirport.sendKeys("Shanghai");
		BrowserUtilities.selectFromList(flightsPage.airportList, "Shanghai (PVG - Pudong Intl.)");
		flightsPage.departingDate.click();
		flightsPage.setDate("2020", "4", "6").click();
		//flightsPage.selectMonthYearDay("May", "2020", "25");
		BrowserUtilities.waitFor(3);
		flightsPage.returningDate.click();
		BrowserUtilities.waitFor(3);
		flightsPage.setDate("2020", "4", "15").click();
		//flightsPage.selectMonthYearDay("Sep", "2020", "15");
		BrowserUtilities.waitFor(3);
		BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, "2");
		BrowserUtilities.selectByValue(flightsPage.childrenNumber,"1");
		BrowserUtilities.selectByValue(flightsPage.childAge,"9");
		
		}

	@Then("I should see correct flights")
	public void i_should_see_correct_flights() {
	    System.out.println("pass");
	}

	
	
}
