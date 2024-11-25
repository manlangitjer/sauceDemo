@login
Feature: Login Page of demo app

  @login_1
  Scenario Outline: Verify login with standard user
    Given User is on login page
    When user enters the credential for "<userName>"
    And user clicks the login button
    Then The system should be displayed properly using "<userName>"
    And Close the browser

Examples:
				|userName				|
				|standard_user	|
				|locked_out_user|
    
    #
  #@login_2
  #Scenario: Verify login with lock out user
    #Given User is on login page
    #When user enters the credential for "locked_out_user"
    #And user clicks the login button
    #Then The user should not be able to login and error message is displayed
    #And Close the browser 