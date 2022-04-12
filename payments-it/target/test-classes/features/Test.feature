@add_customer
Feature: Add Customer

  Scenario Outline: Add new customer details

    Given a request to post customer details
    When add customer is called
    Then "<status_code>" returned as response status code must match
    And "<status_message>" returned as status message must match
    And customer id returned must match with "<customer_id>"

    Examples:
      | customer_id | status_code| status_message
      | 40          | 200        | SUCCESS
