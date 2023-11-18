Feature: LUMA User Login

  Background:
    Given the home page is opened

    # 3 points
  Scenario: Correct login attempt
    Given the 'SignIn' button is clicked
    And the 'Email' field is filled with 'surfersou@gmail.com'
    And the 'Password' field is filled with '5QUeYu..Vt6swvc'
    When the 'LogIn' button is clicked
    Then the user is directed to 'https://magento.softwaretestingboard.com/'


