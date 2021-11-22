package org.vapasi.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{

    @FindBy(id = "quantity")
    private WebElement qunatity;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(){
        qunatity.clear();
        qunatity.click();
        addToCart.click();
    }
}
