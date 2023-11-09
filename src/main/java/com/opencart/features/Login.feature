Feature: Login related test cases
@Run1
Scenario Outline: An error message is displayed when using invalid credentials for login form
  Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
  When the login form is populated with the following details
    | <email>    |
    | <password> |
  And the login button is clicked
  Then the following list of error messages is displayed:
    | Warning: No match for E-Mail Address and/or Password. |
  Examples:
    | email             | password     |
    | ilincue@gmail.com | password33## |
    | gigica@gtail.com  | password12!! |