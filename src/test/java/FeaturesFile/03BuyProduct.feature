Feature:Product buying

  Scenario: Adding notebook to cart and checkout
    Given Home Page of NopCommerce
    When Adding notebook in cart
    And Checkout the product
    And Login with valid credential
    And Checkout the product again
    And Billing address
    And Shipping method
    And Payment method
    And Confirm Order
    And Checkout Confirm
    Then Verify product
    And Browser close