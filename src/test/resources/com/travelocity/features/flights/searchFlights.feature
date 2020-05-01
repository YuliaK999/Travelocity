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
	
  Scenario: Verify flight search
    When I enter flight details
    And I click on Search button
    Then I should see correct flights
   
