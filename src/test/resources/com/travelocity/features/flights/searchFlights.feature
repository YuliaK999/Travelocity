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
    
  Scenario: Verify number of children
 		When I select 2 children
 		Then 2 options to enter children age shoud be displayed
    
  Scenario: Verify Roundtrip trip type
 	  When I select "Roundtrip" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed
 	  
 	Scenario: Verify One way trip type
 	  When I select "One way" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed
 	  
 	Scenario: Verify Multy-city trip type
 	  When I select "Multy-city" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed
 	  
 	Scenario: Verify the flight ticket with excel
 		When I select "One way" as a trip type
    And I enter the flight details
    And I click on Search button
    Then The details of the cheapest flight ticket should be correct
 	  
 	  
 #	  Scenario Outline: Verify airports in the flight ticket
 	#  When I select "One way" as a trip type
 	 # And I enter the following airport names
 	  # Examples:
  	#|fromAirport						|toAirport								  |
    #|Istanbul (IST-Istanbul)|Shanghai (PVG-Pudong Intl.)|
 	  
 	  
 	  
 # Scenario: Verify flight search
  #  When I enter the following flight details
   # |Flying from						|Flying to									|Day|Month|Year|Adults|Children	|Child age |
    #|Istanbul (IST-Istanbul)|Shanghai (PVG-Pudong Intl.)|8	|9		|2020|2			|1				|5				 |
    
 #   Examples:
  #  |fromAirport						 |toAirport								   |departDate|adults |children|childAge|
   # |Istanbul (IST-Istanbul)|Shanghai (PVG-Pudong Intl.)|09/08/2020|2			|1			 |5				|
    
  