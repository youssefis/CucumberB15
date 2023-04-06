package com.smartBear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SmartBearOrderPage {

    public SmartBearOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement productDropDown;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerNameBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement streetAddressBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement cityBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement stateBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCodeBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visa;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpress;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumberBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expirationDateBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(tagName = "strong")
    WebElement message;

    public void provides_product_information(String product, String quantity) {
        BrowserUtils.selectBy(productDropDown, product, "text");
        this.quantity.sendKeys(quantity);
    }

    public void provides_address_information(String customerName, String street, String city, String state, String zipcode) {
        customerNameBox.sendKeys(customerName);
        streetAddressBox.sendKeys(street);
        cityBox.sendKeys(city);
        stateBox.sendKeys(state);
        zipCodeBox.sendKeys(zipcode);
    }

    public void provides_payment_information(String cardType,String cardNumber, String expirationDate) {
    selectCard(cardType);
    cardNumberBox.sendKeys(cardNumber);
    expirationDateBox.sendKeys(expirationDate);

    }

    public void user_clicks_process_button_and_validate_message(String message){
        processButton.click();
        Assert.assertEquals(message,BrowserUtils.getText(this.message));
    }

    public void selectCard(String cardType) {
        cardType = cardType.toLowerCase();
        switch (cardType) {

            case "visa":
                visa.click();
                break;
            case "mastercard":
                masterCard.click();
                break;
            case "american express":
                americanExpress.click();
                break;
            default:
                System.out.println("card type is incorrect, please try another card type");
        }

    }


}
