#First Create your hook class and add your @Before and @After
  #Read username,password,url from configuration.properties
  #Start writing your test case in feature file
  #Start creating your Page Object model
    #Login Page  MainPage OrderPage ViewOrderPage
  #Create your Runner class and get the all snips from RUNNER CLASS
  #Put the snips in step definition class
    #ProductCreationStepDef(you can call it like that if you want)
  #Start implementing your page classes
  #Login Page
     #-->username -->Tester   password -->test  LoginButton
  #MainPage
     #orderButton   viewAllOrdersButton
  #OrderPage
     #All the red dots boxes and also state
     #Validation message
  #ViewOrderPage
     #Validate all the information from data table
     #You can think of Arrays.aslist(not first and last one need to be validated
@regression
Feature: Validation account creation for different input

  Scenario Outline: validation account creation for different input
    Given user provides username and password and clicks order Button
    When User provides the '<product>', '<quantity>' for product information
    And user provides '<name>','<street>','<city>','<state>','<zip>' for address information
    And user provides '<cardType>','<cardNumber>','<expirationDate>' for payment information
    Then User clicks process button and validate '<message>'
    And validate all information '<name>','<product>','<quantity>','<street>','<city>','<state>','<zip>','<cardType>','<cardNumber>','<expirationDate>'
    Examples:
      | product     | quantity | name  | street  | city    | state | zip   | cardType         | cardNumber | expirationDate | message                                |
      | MyMoney     | 4        | Yusuf | oakView | chicago | IL    | 60631 | Visa             | 1234567    | 12/12          | New order has been successfully added. |
      | FamilyAlbum | 4        | Yusuf | oakView | chicago | IL    | 60631 | MasterCard       | 1234567    | 12/12          | New order has been successfully added. |
      | ScreenSaver | 4        | Yusuf | oakView | chicago | IL    | 60631 | American Express | 1234567    | 12/12          | New order has been successfully added. |