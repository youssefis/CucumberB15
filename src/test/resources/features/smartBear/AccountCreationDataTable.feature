@regression2
Feature: Validation account creation for different input

  Scenario: validation account creation for different input
    Given user provides username and password and clicks order Button
    When User provides the product, quantity for product information
      | product  | MyMoney |
      | quantity | 4       |
    And user provides name,street,city,state,zip for address information
      | customerName   | yusuf   |
      | street  | OakView |
      | city    | chicago |
      | state   | Il      |
      | zipCode | 60634   |
    And user provides cardType,cardNumber,expirationDate for payment information
      | cardType       | Visa    |
      | cardNumber     | 1234567 |
      | expirationDate | 12/12   |

    Then User clicks process button and validate message
    |New order has been successfully added.|
#    And validate all information '<name>','<product>','<quantity>','<street>','<city>','<state>','<zip>','<cardType>','<cardNumber>','<expirationDate>'
#    Examples:
#      | product     | quantity | name  | street  | city    | state | zip   | cardType         | cardNumber | expirationDate | message                                |
#      | MyMoney     | 4        | Yusuf | oakView | chicago | IL    | 60631 | Visa             | 1234567    | 12/12          | New order has been successfully added. |
