package com.google.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class GoogleMainPage {

    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchBar;

    @FindBy(xpath = "//a//h3")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@id='result-stats']")
    WebElement SearchResultNumberBar;

    @FindBy(xpath = "//div[@id='result-stats']//nobr")
    WebElement SearchTime;

    public void validateHappySearch(String text){
        searchBar.sendKeys(text, Keys.ENTER);
    }

    public boolean validateNumberOfLinks(int number){
        return (allLinks.size()>number);
    }

    public boolean validateNumberOfResults(int number){
        //About 114,000,000 results (0.63 seconds)
        String[]result=BrowserUtils.getText(SearchResultNumberBar).split(" ");
        return Double.parseDouble(result[1].replace(".",""))>number;
    }

    public boolean validateSearchTime(){
        //  (0,34 secondes)
        String[]time=BrowserUtils.getText(SearchTime).split(" ");
        return Double.parseDouble(time[0].replace("(","").replace(",","."))<1.0;

    }

}
