
Feature: Cars search functionality

  Background: 
  
    Given I am on the TravelocityCom homepage
    When Click on cars

  Scenario: Verify cars page title
  Then The cars page title should be Wander Wisely with Cheap Hotels, Flights, Vacations & Travel Deals | Travelocity


  Scenario: Verify picking up field functionality 
  And Click on Picking up
	And Enter "Los" as a pick up location
	Then Picking up field should contain "Los Angeles"
	

  Scenario: Verify check in  field functionality 
  And Click on Drop off
	And Enter "San" as a drop off location
	Then Dropping off field should contain "San Francisco"
	

