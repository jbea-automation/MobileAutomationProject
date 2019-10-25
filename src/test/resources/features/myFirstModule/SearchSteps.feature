@LogIn

Feature: Search Feature

  @test
  Scenario Outline: Verify that the Spotify allow search a song by a text
    Given an user be already logged into the application
      | userName      | password      |
      | validUserName | validPassword |
    When the user do click on the navigation Search button
    And the user enters the word "<textToSearch>" in the search field
    Then the application should display only result that contains the "<textToSearch>" entered

  Examples:
    | textToSearch |
    | hello        |
    | welcome      |