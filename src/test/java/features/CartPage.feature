Feature: Shopping Cart Functionality

  Scenario: Add two products to the cart with a quantity of at least 2 for one product
    Given I am on the product page
    When I add two products to the cart
    And I set the quantity of one product to 2
    Then the cart should contain 2 products with the correct quantity

#  Scenario: Verify the number of products in the cart matches the red badge on the cart icon
#    Given I have added two products to the cart
#    When I look at the cart icon
#    Then the number of items in the cart should match the number in the red badge on the cart icon
#
#  Scenario: Verify the total price matches the price * quantity for all products in the cart
#    Given I have added two products to the cart with correct quantities
#    When I look at the total price of the cart
#    Then the total price should be the sum of the product prices multiplied by their quantities
#
#  Scenario: Complete the purchase and verify the success of the purchase
#    Given I have added products to the cart
#    When I proceed to checkout and complete the payment
#    Then I should see a success message indicating the purchase was completed successfully
