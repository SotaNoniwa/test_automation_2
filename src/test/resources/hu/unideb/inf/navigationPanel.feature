Feature: LUNA Navigation in Side Bar Menu

  Background:
    Given the home page is opened

    # scenario outline + 3 test cases = 5 points
  Scenario Outline: Navigate to other page
    Given the '<panel>' panel is clicked
    Then the user is directed to '<destination>'
    Examples:
      | panel | destination |
      | Yoga panel | https://magento.softwaretestingboard.com/collections/yoga-new.html |
      | 20% Off panel | https://magento.softwaretestingboard.com/promotions/pants-all.html |
      | Science panel | https://magento.softwaretestingboard.com/collections/performance-fabrics.html |
#      | 3 + 1 panel | https://magento.softwaretestingboard.com/promotions/tees-all.html |
#      | Erin panel | https://magento.softwaretestingboard.com/collections/erin-recommends.html |
#      | Eco-friendly panel | https://magento.softwaretestingboard.com/collections/eco-friendly.html |