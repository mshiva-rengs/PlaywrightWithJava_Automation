Feature: WebDriverUniversity.com - Contact Us Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the contact us button

  Scenario: Valid Contact Us Form Submission
    And I type a first name
    And I type a last name
    And I enter an email address
    And I type a comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: invalid Contact Us Form Submission
    And I type a first name
    And I type a last name
    #And I enter an email address
    And I type a comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Valid Contact Us Form Submission - using specific data
    And I type a specific first name "Sarah"
    And I type a specific last name "Woods"
    And I enter a specific email address "Sarah_Woods@example.com"
    And I type a specific text "Hello World" and a number within the comment input field
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Valid Contact Us Form Submission - using random data

    And I type a random first name
    And I type a random last name
    And I enter an random email address
    And I type a comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message


  Scenario Outline: Valid Contact Us page- using scene outline
    And I type a first name <firstName> and a last name <lastName>
    And I type an email address '<emailAddress>' and a comment '<comment>'
    And I click on the submit button
    Then I should be presented with a header text '<message>'

    Examples:
      | firstName | lastName | emailAddress       | comment           | message                     |
      | mingas    | makola   | mingas@example.com | Hello World       | Thank You for your message! |
      | minga     | makla    | ngas@example.com   | Hello World       | Thank You for your message! |
      | mingas    | makola   | mingas@examplecom  | Hello World tumza | Error: Invalid email Address |

