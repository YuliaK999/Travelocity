Feature: Verify Flight search
#  @test  
  Scenario: Verify Roundtrip trip type
 	  When I select "Roundtrip" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed
# 	@test
 	Scenario: Verify One way trip type
 	  When I select "One way" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed
 	  
 	Scenario: Verify multy-city trip type
 	  When I select "Multy-city" as a trip type
 	  And I enter random flight details
 	  And I click on Search button
 	  Then Flight tickets of corresponding trip type should be displayed
 #	@test  
 	Scenario: Verify the flight ticket with excel
 		When I select "One way" as a trip type
    And I enter the flight details
    And I click on Search button
    Then The details of the cheapest flight ticket should be correct
 	  
 @test	  
 	Scenario Outline: Verify airports in the flight ticket
#   	When I select "One way" as a trip type
 	  When I enter "<departing city>" as a departing city
 	  And I enter "<arrival city>" as an arrival city
 	  And I enter "<departing date>" as a departing date
 	  And I click on Search button 
 	  Then Flight tickets should contain "<DA1>", "<DA2>", "<DA3>" as departure airports  
 	  		   	
 	 		Examples:
   		|departing city |arrival city |departing date |DA1 |DA2 |DA3 |
   		|Moscow 				|Istanbul		  |09/09/2020			|VKO |SVO |DME |
 	  	|New York				|Shanghai			|09/09/2020			|JFK |EWR |LGA |
 	  
 	  
    
  