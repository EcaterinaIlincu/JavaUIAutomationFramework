Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed

  Scenario: Register Page can be accessed from the Home Page
    Given "/" endpoint is accessed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page url is opened when the registration is successful
    And registerLink from Header menu is clicked
    When the register form is populated with valid random data
    And Continue button is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on registerPage when the continue button is not clicked
    When the register form is populated with valid random data
    Then the current url contains "route=account/register" keyword

  @Run
  Scenario Outline: An error message is displayed when invalid <impacted attribute> is used for register flow
    And  the register form is populated with the following data:
      | firstName | <firstName>    |
      | lastName  | <lastName>     |
      | email     | <emailData>    |
      | password  | <passwordData> |
    When Continue button is clicked
    Then the following list of error messages is displayed:
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                             | lastName                              | emailData | passwordData |
      | First Name         | t55yy5y75y5y5y5y5yy5y5y5y5y5yy5y5y113 | Random                                | Random    | Random       |
      | Last Name          | Random                                | t55yy5y75y5y5y5y5yy5y5y5y5y5yy5y5y224 | Random    | Random       |
      | First Name         | t55yy5y75y5y5y5y5yy5y5y5y5y5yy5y5y113 | Random                                | Random    | Random       |
      | Last Name          | Random                                | t55yy5y75y5y5y5y5yy5y5y5y5y5yy5y5y224 | Random    | Random       |


