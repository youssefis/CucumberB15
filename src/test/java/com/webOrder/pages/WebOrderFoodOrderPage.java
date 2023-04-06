package com.webOrder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderFoodOrderPage {
    public WebOrderFoodOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderBox;

    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;

    @FindBy(css = "#InviteNote")
    WebElement inviteesSection;

    @FindBy(css = "#InviteList")
    WebElement inviteList;

    @FindBy(css = "#ConfirmAddressID")
    WebElement deliveryAddressBox;

    @FindBy(css = "#addressPreview")
    WebElement selectedAddress;

    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement pageHeader;

    @FindBy(xpath = "//div[@id='mainColumn']//div[@class='col']//p[1]")
    WebElement paragraph;

    public void clicks_group_order_box_and_next_button(){
        groupOrderBox.click();
        nextButton.click();
    }

    public void sends_the_word_for_note_to_the_invitees_section(String word){
        inviteesSection.sendKeys(word);
    }

    public void sends_e_mail_address_which_are_and_to_the_invite_list(String email1,String email2){
        inviteList.sendKeys(email1+", "+email2);
    }

    public void choose_the_delivery_address_and_validate_the_address(String deliveryAddress,String expectedAddress){
        BrowserUtils.selectBy(deliveryAddressBox,deliveryAddress,"text");
        Assert.assertTrue(BrowserUtils.getText(selectedAddress).contains(expectedAddress));
    }

    public void clicks_the_create_group_order_button(){
        createGroupOrderButton.click();
    }

    public void validates_the_header_of_page(String header){
        Assert.assertEquals(header,BrowserUtils.getText(pageHeader));
    }

    public void validates_that_the_description_contains_the_words(String text){
        Assert.assertTrue(BrowserUtils.getText(paragraph).contains(text));
    }


}
