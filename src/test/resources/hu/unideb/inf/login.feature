Feature: LUMA User Login

  Background:
    Given the home page is opened

    # scenario outline + 2 test cases = 4 points
  Scenario Outline: Login attempts with incorrect email input
    Given the 'SignIn' button is clicked
    And the 'Email' field is filled with '<email>'
    And the 'Password' field is filled with '<password>'
    When the 'LogIn' button is clicked
    Then the '<emailError>' email message is shown
    Examples:
      | email         | password | emailError                                                   |
      |               | 1234     | This is a required field.                                    |
      | invalid@email | 1234     | Please enter a valid email address (Ex: johndoe@domain.com). |

    # scenario = 3 points
  Scenario: Login attempts with empty password input
    Given the 'SignIn' button is clicked
    And the 'Email' field is filled with 'surfersou@gmail.com'
    And the 'Password' field is filled with ''
    When the 'LogIn' button is clicked
    Then the 'This is a required field.' password message is shown

    # scenario = 3 points
  Scenario: Login attempts with wrong password input
    Given the 'SignIn' button is clicked
    And the 'Email' field is filled with 'surfersou@gmail.com'
    And the 'Password' field is filled with '1234'
    And the 'LogIn' button is clicked
    Then the user is directed to 'https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/'
    Then the 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.' login message is shown

    # scenario = 3 points
  Scenario: Correct login attempt
    Given the 'SignIn' button is clicked
    And the 'Email' field is filled with 'surfersou@gmail.com'
    And the 'Password' field is filled with '5QUeYu..Vt6swvc'
    When the 'LogIn' button is clicked
    Then the user is directed to 'https://magento.softwaretestingboard.com/'

