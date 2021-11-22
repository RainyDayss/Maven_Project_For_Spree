package org.vapasi.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    //@FindBy(id = "order_email")
  //  private WebElement orderEmail;

    @FindBy(id = "order_bill_address_attributes_firstname")
    private WebElement firstName;

    @FindBy(id = "order_bill_address_attributes_lastname")
    private WebElement lastName;

    @FindBy(id = "order_bill_address_attributes_address1")
    private WebElement address1;

    @FindBy(id = "order_bill_address_attributes_city")
    private WebElement city;

    @FindBy(id = "order_bill_address_attributes_state_id")
    private WebElement state;

    @FindBy(id = "order_bill_address_attributes_zipcode")
    private WebElement zipCode;

    @FindBy(id = "order_bill_address_attributes_country_id")
    private WebElement country;


    @FindBy(id = "order_bill_address_attributes_phone")
    private WebElement phoneNumber;

    @FindBy(name = "commit")
    private WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(),'UPS Ground (USD')]")
    private WebElement shippingMethod;

    @FindBy(id = "order_payments_attributes__payment_method_id_3")
    private WebElement paymentMethod;

    //@FindBy(xpath = "//div[contains(text(),'Your order has been processed successfully')]")
  //  private WebElement orderMessage;

    public CheckoutPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public void selectState()
    {
        Select select = new Select(state);
        select.selectByVisibleText("Washington");
    }
    public void selectCountry()
    {
        Select select = new Select(country);
        select.selectByVisibleText("United States of America");
    }
    public void selectShippingMethod()
    {
        shippingMethod.click();
        saveButton.click();
    }
    public void selectPaymentMethod()
    {
        paymentMethod.click();
        saveButton.click();
    }
    public void addAddressDetail(String fName,String lName,String addressDetail,
                                 String cityDetail,String zip,String phoneNo)
    {
        //orderEmail.sendKeys(email);
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        address1.sendKeys(addressDetail);
        selectCountry();
        selectState();
        city.sendKeys(cityDetail);
        zipCode.sendKeys(zip);
        phoneNumber.sendKeys(phoneNo);
        saveButton.click();
    }

}

