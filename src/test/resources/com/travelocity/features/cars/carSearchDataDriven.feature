


Feature: Car Search Functionality Using Data
  

  Background: 
  
    Given I am on the TravelocityCom homepage
    When Click on cars
 

  
   Scenario Outline: Verify Page Title Using Scenerio Outline
    When User click on "<Piking up>"
    When User click" <Drop off> "
    When User click "<Pick up date>" 
    When User click "<Pick up time>"
    When User click "<Drop off date>"
    When User click "<Drop off time>"
    And User click on Search button
    Then verify page title

    Examples: 
      | Picking up    |  Drop off    | Pick up date |  Pick up time   | Drop off date | Drop off time |
      | Istanbul      |    Izmir     | 05/20/2020   |  11:00AM        | 05/26/2020    |10:00AM        |
      | Antalya       |    Ankara    |  05/25/2020  |  10:00AM        | 05/27/2020    |01:00PM        |
