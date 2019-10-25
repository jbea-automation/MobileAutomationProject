@LogIn

Feature: LogIn Feature

  Scenario: Verify that the Spotify application icon be displayed
    Given an user access to the spotify application
    When the main page be loaded successfully
    Then verify that the spotify logo icon be displayed


  Scenario: Verify that the Spotify application logIn button be displayed
    Given an user access to the spotify application
    When the main page be loaded successfully
    And do click in log in button
    Then verify that the spotify logo icon be displayed

  Scenario: Verify that the Spotify application display an error message if you try to do login with invalid credentials
    Given an user be in the login page
    When the user enter his user credential "invalidUserName"
    And the user enter his user credential "invalidPassword"
    And the user do click on login button
    Then verify that the following error message be displayed "This email and password combination is incorrect."

  Scenario: Verify that the Spotify application shows the setting button after the user be loaded successfully
    Given an user be in the login page
    When the user enter his user credential "validUserName"
    And the user enter his user credential "validPassword"
    And the user do click on login button
    Then verify that the setting button be displayed into the home page
    