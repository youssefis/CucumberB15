package com.webOrder.stepDefinitions;

import com.webOrder.pages.WebOrderFoodOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebOrderFoodOrderStepDef {
    WebDriver driver = DriverHelper.getDriver();
    WebOrderFoodOrderPage webOrderFoodOrderPage = new WebOrderFoodOrderPage(driver);

    @When("User clicks Group Order Box and Next Button")
    public void user_clicks_group_order_box_and_next_button() {
        webOrderFoodOrderPage.clicks_group_order_box_and_next_button();
    }

    @When("User sends the word {string} for note to the invitees Section")
    public void user_sends_the_word_for_note_to_the_invitees_section(String word) {
        webOrderFoodOrderPage.sends_the_word_for_note_to_the_invitees_section(word);
    }

    @When("User sends e-mail address which are {string} and {string} to the invite List")
    public void user_sends_e_mail_address_which_are_and_to_the_invite_list(String email1, String email2) {
        webOrderFoodOrderPage.sends_e_mail_address_which_are_and_to_the_invite_list(email1, email2);
    }

    @When("User choose the delivery address {string} and validate the address {string}")
    public void user_choose_the_delivery_address_and_validate_the_address(String deliveryAddress, String expectedAddress) {
        webOrderFoodOrderPage.choose_the_delivery_address_and_validate_the_address(deliveryAddress, expectedAddress);
    }

    @When("user clicks the create Group order Button")
    public void user_clicks_the_create_group_order_button() throws InterruptedException {
        webOrderFoodOrderPage.clicks_the_create_group_order_button();
        Thread.sleep(1000);
    }

    @Then("User validates the header of page {string}")
    public void user_validates_the_header_of_page(String expectedHeader) {
        webOrderFoodOrderPage.validates_the_header_of_page(expectedHeader);
    }

    @Then("User validates that the description contains the words {string}")
    public void user_validates_that_the_description_contains_the_words(String text) {
    webOrderFoodOrderPage.validates_that_the_description_contains_the_words(text);
    }


}
