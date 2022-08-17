Feature: Test Login functionality

  @Login
  Scenario: As a user I enter my account with my username and password
    Given I am on the login page
    When I enter my username
    When I enter my password
    And click on the login button
    Then I enter to my account correctly
    And the logout button is visible

    @WrongTest
  Scenario: As a user I enter wrong my password
    Given Im on the login page
    When I enter my user
    When I enter wrong my password
    And click on login button
    Then I can see an incorrect password message

  @WrongUsername
  Scenario: As a user I enter wrong my username
    Given Im in the login page
    When I enter wrong my user
    When I enter my pass
    And click in the login button
    Then I can see an incorrect username message
