package com.google.stepDefinitions;

import com.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    @Given("User navigates to the Google")
    public void user_navigates_to_the_google() {
        driver.get(ConfigReader.readProperty("googleUrl"));
    }

    @When("User Searchs for Codefish")
    public void user_searchs_for_codefish() {
    googleMainPage.validateHappySearch("codefish");
    }

    @Then("User gets more than ten links on the first page")
    public void user_gets_more_than_ten_links_on_the_first_page() {
        Assert.assertTrue(googleMainPage.validateNumberOfLinks(5));
    }

    @When("User Searchs for kyrgyz food  in usa")
    public void user_searchs_for_kyrgyz_food_in_usa() {
        googleMainPage.validateHappySearch("kyrgyz food  in usa");
    }

    @Then("User validate the result")
    public void user_gets_more_one_hundred_and_fourteen_million_results() {
        Assert.assertTrue(googleMainPage.validateNumberOfResults(100000000));
    }

    @When("User Searchs for turkish baklava")
    public void user_searchs_for_turkish_baklava() {
        googleMainPage.validateHappySearch("turkish baklava");
    }

    @Then("User validate search is done less than one second")
    public void user_validate_search_is_done_less_than_one_second() {
        Assert.assertTrue(googleMainPage.validateSearchTime());
    }
}
