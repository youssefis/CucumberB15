package com.google.stepDefinitions;

import com.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDrive();
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
        Assert.assertTrue(googleMainPage.validateNumberOfLinks());
    }
}
