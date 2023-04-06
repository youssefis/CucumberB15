package com.webOrder.stepDefinitions;

import com.webOrder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebOrderLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage=new WebOrderLoginPage(driver);
    @When("User provides {string} and {string} WebOrder")
    public void user_provides_and_web_order(String username, String password) {
        webOrderLoginPage.webOrderLogin(username,password);
    }
    @Then("User validates the {string} from homepage")
    public void user_validates_the_from_homepage(String title) {
        Assert.assertEquals(title,driver.getTitle().trim());
    }

    @When("When User provides {string} and {string} WebOrder")
    public void when_user_provides_and_web_order(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User validates the {string} error message")
    public void user_validates_the_error_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User validates {string} error message")
    public void user_validates_error_message(String expectedErrorMessage) {
    Assert.assertEquals(expectedErrorMessage,webOrderLoginPage.validateErrorMessage());
    }

}
