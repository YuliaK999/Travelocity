package com.travelocity.step_definitions;

import org.junit.Assert;

import java.util.List;

import com.travelocity.beans.HotelRooms;
import com.travelocity.pages.HotelResultPage;
import com.travelocity.utilities.BrowserUtilities;
import com.travelocity.utilities.Driver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class HotelRoomsStepDefs {
	
	
	
	@When("Click on {string} hotel name")
	public void click_on_hotel_name(String string) {
		Driver.getDriver().manage().deleteAllCookies();
		HotelResultPage hotelResultPage = new HotelResultPage();
		String parentWindowId= Driver.getDriver().getWindowHandle();
		hotelResultPage.hotelName.click();
		Driver.getDriver().switchTo().window(parentWindowId);
	}

	@When("Click on Rooms")
	public void click_on_Rooms() {
		HotelResultPage hotelResultPage = new HotelResultPage();
		hotelResultPage.rooms.click();
	}

	@Then("Room details should be as following")
	public void room_details_should_be_as_following(List<HotelRooms> rooms) {
		HotelResultPage hrPage = new HotelResultPage();
		
		for (HotelRooms room : rooms) {
			//Assert.assertTrue(hrPage.description.getText().contains(room.getDescription()));
			Assert.assertEquals(hrPage.price.getText(),room.getPrice());
			Assert.assertTrue(hrPage.numberOfGuests.getText().contains(room.getNumberOfGuests()));
			Assert.assertTrue(hrPage.square.getText().contains(room.getSquare()));
			Assert.assertEquals(hrPage.bed.getText(),room.getBed());
	}


	}
}
