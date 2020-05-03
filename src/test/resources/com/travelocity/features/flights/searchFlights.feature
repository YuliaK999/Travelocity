@testing
Feature: Verify Flights search page

  Background: 
    Given I am on the flights page
	
  Scenario: Verify flights page
    When I click on Hotels button
    And I click on Flights button
    Then I should land on flights page

  
  Scenario: Verify dropdown suggestions by keyword
    When I type a keyword into Flying from field
    Then I should see suggested options in the dropdown

  Scenario: Verify Clear button
    When I type a keyword into Flying from field
    And I click on Clear button
    Then Flying from field should get cleared

  Scenario: Verify error messages
    When I click on Search button
    Then Error messages should be displayed
    
  Scenario: Verify flight type
 	  When I select trip type as the following
 	  						| Roundtrip |
								| One way		|
								| Multy-city|
 	  And I enter the random flight details
 	  And I click on Search button
 	  Then Flight tickets of the correct trip type should be displayed
 	  
 	Scenario: Verify number of children
 		When I select 2 children
 		Then 2 options to enter children age shoud be displayed
 	  
	
 # Scenario: Verify flight search
  #  When I enter the following flight details
   # |Flying from						|Flying to									|Day|Month|Year|Adults|Children	|Child age |
    #|Istanbul (IST-Istanbul)|Shanghai (PVG-Pudong Intl.)|8	|9		|2020|2			|1				|5				 |
    
 #   Examples:
  #  |fromAirport						 |toAirport								   |departDate|adults |children|childAge|
   # |Istanbul (IST-Istanbul)|Shanghai (PVG-Pudong Intl.)|09/08/2020|2			|1			 |5				|
    
   # And I click on Search button
    #And I click on Nonstop checkbox
    #Then The flight details have to be as following
    #|departureTime|arrivalTime|airline 				 |rating|duration|numberOfStops|fromAirport|toAirport|price|typeOfTrip|
    #|1:25am				|4:45pm			|Turkish Airlines|8.5		|10h 20m |Nonstop			 |IST				 |PVG			 |$376 |one way	  |
   	#|1:25am				|4:45pm			|Air China			 |8.5		|10h 20m |Nonstop			 |IST				 |PVG			 |$666 |one way	  |
