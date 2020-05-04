Feature: Hotel rooms
  
 
  Scenario: Verify hotel rooms
    Given I am on the TravelocityCom homepage
    When Click on hotels
   	And Click on Going to field
		And Enter "Florida" destination
		And Click on Check in field
		And Set "May" 10 2020 date to Check in field
		And Click on Check out field
		And Set "May" 11 2020 date to Check out field
    And Click Search button
    And Click on "Comfort Suites Sarasota - Siesta Key" hotel name
    And Click on Rooms
    Then Room details should be as following
  	|Description|Price|Number of guests |Square|Bed| 
		|      |        |       |          |
				
