package com.smartBear.stepDefinition;

import com.smartBear.pages.SmartBearLoginPage;
import com.smartBear.pages.SmartBearOrderPage;
import com.smartBear.pages.SmartBearViewAllOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartBearOrderStepDef {
    WebDriver driver = DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage(driver);
    SmartBearViewAllOrderPage smartBearViewAllOrderPage = new SmartBearViewAllOrderPage(driver);

    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage(driver);

    @Given("user provides username and password and clicks order Button")
    public void user_provides_username_and_password_and_clicks_order_button() {
        smartBearLoginPage.provides_username_and_password(ConfigReader.readProperty("SmartBearUsername"), ConfigReader.readProperty("SmartBearPassword"));
        smartBearViewAllOrderPage.clicks_order_button();
    }

    @When("User provides the {string}, {string} for product information")
    public void user_provides_the_for_product_information(String product, String quantity) {
        smartBearOrderPage.provides_product_information(product, quantity);
    }

    @When("user provides {string},{string},{string},{string},{string} for address information")
    public void user_provides_for_address_information(String name, String street, String city, String state, String zipCode) {
        smartBearOrderPage.provides_address_information(name, street, city, state, zipCode);
    }

    @When("user provides {string},{string},{string} for payment information")
    public void user_provides_for_payment_information(String cardType, String cardNumber, String expirationDate) {
        smartBearOrderPage.provides_payment_information(cardType, cardNumber, expirationDate);
    }

    @Then("User clicks process button and validate {string}")
    public void user_clicks_process_button_and_validate(String expectedMessage) {
        smartBearOrderPage.user_clicks_process_button_and_validate_message(expectedMessage);
    }

    @Then("validate all information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void validate_all_information(String name, String product, String quantity, String streetAddress, String city, String state, String zipCode, String cardType, String cardNumber, String expirationDate) {
        smartBearViewAllOrderPage.validate_all_information(name, product, quantity, streetAddress, city, state, zipCode, cardType, cardNumber, expirationDate);
    }


    @When("User provides the product, quantity for product information")
    public void user_provides_the_product_quantity_for_product_information(DataTable dataTable) {
        Map<String, String> productInformation = dataTable.asMap();
        //System.out.println(productInformation); // {product=MyMoney, quantity=4}
        smartBearOrderPage.provides_product_information(productInformation.get("product"), productInformation.get("quantity"));
    }

    @When("user provides name,street,city,state,zip for address information")
    public void user_provides_customerName_street_city_state_zipCode_for_address_information(DataTable dataTable) {
        Map<String, String> addressInformation = dataTable.asMap();
        smartBearOrderPage.provides_address_information(addressInformation.get("customerName"),
                addressInformation.get("street"),
                addressInformation.get("city"),
                addressInformation.get("state"),
                addressInformation.get("zipCode"));
    }

    @When("user provides cardType,cardNumber,expirationDate for payment information")
    public void user_provides_card_type_card_number_expiration_date_for_payment_information(DataTable dataTable) {
        Map<String, String> paymentInformation = dataTable.asMap();
        smartBearOrderPage.provides_payment_information(paymentInformation.get("cardType"),
                paymentInformation.get("cardNumber"),
                paymentInformation.get("expirationDate"));
    }

    @Then("User clicks process button and validate message")
    public void user_clicks_process_button_and_validate_message(io.cucumber.datatable.DataTable dataTable) {
        List<String> message=dataTable.asList();
        smartBearOrderPage.user_clicks_process_button_and_validate_message(message.get(0));
    }



}
