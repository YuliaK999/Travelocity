package com.travelocity.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;
import com.travelocity.pages.FlightResultPage;
import com.travelocity.pages.FlightsPage;
import com.travelocity.step_definitions.FlightSearchStepDefs;
import com.travelocity.utilities.LoggerUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
	
	/*@When("I enter flight details")
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
		flightsPage.returningDate.click();
		flightsPage.setDate("2020", "4", "15").click();
		BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, "2");
		BrowserUtilities.selectByValue(flightsPage.childrenNumber,"1");
		BrowserUtilities.selectByValue(flightsPage.childAge,"9");
		
		}*/
	
	@When("I select {int} children")
	public void i_select_children(Integer int1) {
		FlightsPage flightsPage = new FlightsPage();
		BrowserUtilities.selectByValue(flightsPage.childrenNumber,int1+""); // from 0 to 6
	}

	@Then("{int} options to enter children age shoud be displayed")
	public void options_to_enter_children_age_shoud_be_displayed(Integer int1) {
		FlightsPage flightsPage = new FlightsPage();
		int count = 0;
		if (int1==0) { 
			Assert.assertFalse(flightsPage.childAge.isDisplayed());
		}else { 
			//Assert.assertTrue(flightsPage.checkNumberOfChildren(int1).isDisplayed());
			for (WebElement age : flightsPage.childAgeList) 
				if (age.isDisplayed()) count++;
			Assert.assertTrue(int1==count);
		}	
	}


	@When("I select trip type as {string}")
	public void i_select_trip_type_as(String tripType) {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.setTripType(tripType).click();
	}

	@When("I enter the random flight details")
	public void i_enter_the_flight_details_for(List<String> tripTypes) {
		FlightsPage flightsPage = new FlightsPage();
		Faker f = new Faker();
		for (String tripType : tripTypes) {
		switch(tripType) {
		case "Roundtrip": 
			flightsPage.flyingFromAirport.sendKeys(f.aviation().airport()); //airport from Faker class
			flightsPage.flyingToAirport.sendKeys(f.aviation().airport()); //airport from Faker class
			flightsPage.departingDate.click();
			flightsPage.setDate("2020", "9", "8").click();
			flightsPage.returningDate.click();
			flightsPage.setDate("2020", "9", "15").click();
			BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, new Random().nextInt(6)+1+""); //
			BrowserUtilities.selectByValue(flightsPage.childrenNumber,"0");
			break;
		case "One-way": 
			flightsPage.flyingFromAirport.sendKeys(f.aviation().airport()); //airport from Faker class
			flightsPage.flyingToAirport.sendKeys(f.aviation().airport()); //airport from Faker class
			flightsPage.departingDate.click();
			flightsPage.setDate("2020", "9", "8").click();
			BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, new Random().nextInt(6)+1+""); //random number from 1 to 6
			BrowserUtilities.selectByValue(flightsPage.childrenNumber,"0");
			break;
		case "Multi-city":
			String transferAirport = f.aviation().airport();
			flightsPage.flyingFromAirport.sendKeys(f.aviation().airport()); //airport from Faker class
			flightsPage.flyingToAirport.sendKeys(transferAirport); //transferAirport
			flightsPage.departingDate.click();
			flightsPage.setDate("2020", "9", "8").click();
			BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, new Random().nextInt(6)+1+""); //
			BrowserUtilities.selectByValue(flightsPage.childrenNumber,"0");
			flightsPage.flyingFromAirport2.sendKeys(transferAirport); //airport from Faker class
			flightsPage.flyingToAirport2.sendKeys(f.aviation().airport()); //transferAirport
			flightsPage.departingDate2.click();
			flightsPage.setDate("2020", "9", "15").click();
			break;
			}
		}
	}

	@Then("The result page should also display {string}")
	public void the_result_page_should_also_display(String expected) {
		FlightResultPage flightResultPage = new FlightResultPage();
		String actual = flightResultPage.typeOfTrip.getText();
		Assert.assertEquals(expected.toLowerCase(), actual);
	}

	
	
}
