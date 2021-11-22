package org.vapasi.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
    @FindBy(id = "checkout-link")
    private WebElement checkout;

    public CartPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
}

public void checkoutProduct()
{
    checkout.click();
}

  /*  public void emptyCart(WebDriver driver)
    {
    //driver.findElement(By.linkText("Empty Cart"));
    //driver.findElement(By.id("clear_cart_link")).click();
driver.findElement(By.cssSelector("input[name='commit']")).click();
    }*/
}

