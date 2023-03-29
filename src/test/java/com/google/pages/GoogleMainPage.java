package com.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleMainPage {

    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchBar;

    @FindBy(xpath = "//a//h3")
    List<WebElement> allLinks;

    public void validateHappySearch(String text){
        searchBar.sendKeys(text, Keys.ENTER);
    }

    public boolean validateNumberOfLinks(){
        return (allLinks.size()>5);
    }

}
