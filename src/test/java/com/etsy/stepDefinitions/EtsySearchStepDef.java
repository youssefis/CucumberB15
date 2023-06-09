package com.etsy.stepDefinitions;


import com.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;


public class EtsySearchStepDef {

    WebDriver driver = DriverHelper.getDriver();
    EtsyMainPage etsyMainPage = new EtsyMainPage(driver);

    @When("User Searches for {string} for Etsy WebPage")
    public void user_searches_for_for_etsy_web_page(String SearchItem) {
        etsyMainPage.searchingItem(SearchItem);
    }

    @Then("User validates the title {string} from Etsy")
    public void user_validates_the_title_from_etsy(String title) {
        Assert.assertEquals(title, driver.getTitle().trim());
    }


}
