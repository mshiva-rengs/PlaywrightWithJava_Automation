Feature: WebDriverUniversity.com - Login Page

 Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    And I click on the login portal button

  Scenario: Login with Valid Credentials
    When I type a username
    And I type a password
    And I click on the login button
    Then I should be presented with a successful login message

  Scenario: Login with Invalid Credentials
    When I type an invalid username
    And I type a password
    And I click on the login button
    Then I should be presented with an error message