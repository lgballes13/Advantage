#Author: Luis Ballesteros

  Feature: Automate the shopping process on the Advantage online store
           Adding different products from various categories and validating the total purchase calculation


    Scenario: Add different products to the cart, validate the total price purchase and finalize the buy
      Given the customer is on the homepage
      When the customer selects the following products and adds them to the cart
        | category | product                    |
        | TABLETS  | HP Pro Tablet 608 G1       |
        | MICE     | HP Z4000 Wireless Mouse    |
        | LAPTOPS  | HP Pavilion 15z Laptop     |
        | TABLETS  | HP ElitePad 1000 G2 Tablet |
      And the customer navigates to the shopping cart
      Then it is validated that the total purchase is equal to the sum of the selected products' prices
      When Enter the credentials for login
      And input the information for payment method
      Then visualize the message "Thank you for buying with Advantage"


    Scenario: Add different products to the cart and validate the total purchase
      Given the customer is on the homepage
      When the customer selects the following products and adds them to the cart
        | category | product                    |
        | TABLETS  | HP Pro Tablet 608 G1       |
        | MICE     | HP Z4000 Wireless Mouse    |
      And the customer navigates to the shopping cart
      Then it is validated that the total purchase is equal to the sum of the selected products' prices
      When remove products from cart


    Scenario: Add different products and eliminated a product for validate the change in total purchase
      Given the customer is on the homepage
      When the customer selects the following products and adds them to the cart
        | category | product                    |
        | TABLETS  | HP Pro Tablet 608 G1       |
        | MICE     | HP Z4000 Wireless Mouse    |
        | LAPTOPS  | HP Pavilion 15z Laptop     |
        | TABLETS  | HP ElitePad 1000 G2 Tablet |
      And the customer navigates to the shopping cart
      Then it is validated that the total purchase is equal to the sum of the selected products' prices
      When the customer eliminated a product what he was dont want buy
      Then validate the new price total purchase




