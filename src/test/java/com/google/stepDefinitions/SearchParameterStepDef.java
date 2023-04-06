package com.google.stepDefinitions;

import com.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchParameterStepDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String url) {
    driver.get(url);
    }

    @When("User Searchs for {string}")
    public void user_searchs_for(String text) {
        googleMainPage.validateHappySearch(text);
    }

    @Then("User gets more Than {int} links from first page")
    public void user_gets_more_than_links_from_first_page(int link) {
        Assert.assertTrue(googleMainPage.validateNumberOfLinks(link));
    }
    @Then("User more than {int} results")
    public void user_more_than_results(Integer int1) {
        Assert.assertTrue(googleMainPage.validateNumberOfResults(int1));
    }
}
