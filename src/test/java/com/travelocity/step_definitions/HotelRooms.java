package com.travelocity.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import com.travelocity.pages.HotelResultPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import com.travelocity.beans.HotelRooms;

public class HotelRooms {
	
	@When("Click on {string} hotel name")
	public void click_on_hotel_name(String string) {
		HotelResultPage hotelResultPage = new HotelResultPage();
		hotelResultPage.hotelName.click();
	}

	@When("Click on Rooms")
	public void click_on_Rooms() {
		HotelResultPage hotelResultPage = new HotelResultPage();
		hotelResultPage.rooms.click();
	}

	@Then("Room details should be as following")
	public void room_details_should_be_as_following(List<HotelRooms> rooms) {
		HotelResultPage hrPage = new HotelResultPage();
		
		//for (HotelRooms room : rooms) {
		//	room.get
			
	}


}

