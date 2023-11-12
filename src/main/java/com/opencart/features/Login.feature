Feature: Login related test cases
@Run1
Scenario Outline: An error message is displayed when using invalid credentials for login form
  Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
  When the following form from "LoginPage" is populated as follow:
    | emailAddressInput | <username> |
    | passwordInput     | <password> |
  And the "loginBtn" from "LoginPage" is clicked
  Then the following list of error messages is displayed:
    | Warning: No match for E-Mail Address and/or Password. |
  Examples:
    | username          | password     |
    | ilincue@gmail.com | password33## |
    | gigica@gtail.com  | password12!! |

  @Regression
  Scenario Outline: Successful login is performed with valid credentials
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the following form from "LoginPage" is populated as follow:
      | emailAddressInput | <username> |
      | passwordInput     | <password> |
    And the "loginBtn" from "LoginPage" is clicked
    Then the current url contains "account" keyword
    Examples:
      | username                | password     |
      | angela.gosta@gmail.com  | angela33##   |
      | cristian.filo@gmail.com | password45$% |