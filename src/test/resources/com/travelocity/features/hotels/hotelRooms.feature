Feature: Hotel rooms
  
 
  Scenario: Verify hotel rooms
    Given I am on the TravelocityCom homepage
    When Click on hotels
   	And Click on Going to field
		And Enter "The Monterey Hotel" destination
#		And Click on Check in field
#		And Set "May" 10 2020 date to Check in field
#		And Click on Check out field
#		And Set "May" 11 2020 date to Check out field
    And Click Search button
    And Click on "The Monterey Hotel" hotel name
    And Click on Rooms
    Then Room details should be as following
  	|Description	|Price|Guests|Square|     Bed    | 
		|Standard Room| $89 |  2   | 182  | 1 Queen Bed|
# custom class		
				
