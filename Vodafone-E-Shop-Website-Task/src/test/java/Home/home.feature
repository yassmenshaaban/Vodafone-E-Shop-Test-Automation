Feature: MakeOrder
  Scenario:leave full name field and show error
    Given navigate to website and login with phoneNumber "01093086979" and password "Mahmoud12*"
    When add item of Iphone brand to card and click checkOut button
    And add address detail and click Save
    Then Address added


  Scenario: delete item of cart
    Given navigate to website and login with phoneNumber "01093086979" and password "Mahmoud12*"
    And add item to Cart
    When go to cart page and click to remove item
    Then show message item is removed