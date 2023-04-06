package com.smartBear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SmartBearViewAllOrderPage {

    public SmartBearViewAllOrderPage(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//a[.='Order']")
    WebElement OrderPageButton;

    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrdersButton;

    @FindBy(xpath = "//tbody//tr[2]//td")
    List<WebElement> allOrderInformation;

    public void clicks_order_button(){
        OrderPageButton.click();
    }

    public void validate_all_information(String name,String product, String quantity, String streetAddress, String city, String state, String zipCode, String cardType,String cardNumber, String expirationDate){
        viewAllOrdersButton.click();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now= LocalDateTime.now();
        String currentTime= dtf.format(now);
        List<String> allInfo= Arrays.asList("",name,product,quantity,currentTime,streetAddress,city,state,zipCode,cardType,cardNumber,expirationDate,""    );

        for (int i=1; i<allOrderInformation.size()-1;i++){
            Assert.assertEquals(allInfo.get(i), BrowserUtils.getText(allOrderInformation.get(i)));
            System.out.println(BrowserUtils.getText(allOrderInformation.get(i)));
        }

    }

}
