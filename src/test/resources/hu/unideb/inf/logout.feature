Feature: LUMA User Logout

  Background:
    Given the home page is opened

    Scenario: User logout after signin
      Given the 'SignIn' button is clicked
      And the 'Email' field is filled with 'surfersou@gmail.com'
      And the 'Password' field is filled with '5QUeYu..Vt6swvc'
      When the 'LogIn' button is clicked
      Then the user is directed to 'https://magento.softwaretestingboard.com/'
      And the 'Expand Sign Out Menu' button is clicked
      And the 'Sign Out' button is clicked
      Then the user is directed to 'https://magento.softwaretestingboard.com/customer/account/logoutSuccess/'
