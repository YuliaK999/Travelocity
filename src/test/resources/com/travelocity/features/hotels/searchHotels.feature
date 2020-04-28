Feature: Hotel search functionality

  Background: 
    Given I am on the TravelocityCom homepage
    When Click on hotels

  Scenario: Verify hotels page title
    Then The hotels page title should be Cheap Hotels: Book Hotel Deals With Our Hotel Finder | Travelocity

  @testing
  Scenario: Verify destenation field functionality 
  And Click on Going to field
	And Enter "Florida" destination
	Then Destination field should contain "Florida"
	