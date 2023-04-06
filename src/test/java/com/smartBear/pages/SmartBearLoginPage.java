package com.smartBear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class SmartBearLoginPage {

    public  SmartBearLoginPage(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy (xpath = "//div[@class='login']//input[1]")
    WebElement usernameBox;

    @FindBy (xpath = "//div[@class='login']//input[2]")
    WebElement passwordBox;

    @FindBy (xpath = "//div[@class='login']//input[3]")
    WebElement loginButton;

    public void provides_username_and_password(String username,String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password );
        loginButton.click();
    }


}
