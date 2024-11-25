@dashboard
Feature: Dashboard Page of demo app
  
  @dashboard_1
  Scenario: Verify price sort from High to Low
    Given User is on login page
    When user enters the credential for "standard_user"
    And user clicks the login button
    And user sorts the products by "Price (high to low)"
    Then The products should be sorted by "Price (high to low)"
    And Close the browser 
    
    
  @dashboard_2
  Scenario: Verify Cart by the selected products
    Given User is on login page
    When user enters the credential for "standard_user"
    And user clicks the login button
    And user sorts the products by "Price (high to low)"
    And user select products with "15.99" price
    And user clicks the Cart button
    Then the selected products should be displayed properly
    
  @dashboard_3
  Scenario: Verify summary section
    Given User is on login page
    When user enters the credential for "standard_user"
    And user clicks the login button
    And user sorts the products by "Price (high to low)"
    And user select products with "15.99" price
    And user clicks the Cart button
    And user clicks the Checkout button
    And user fills out the information form
    And user clicks the Continue button
    Then the selected products should be displayed properly