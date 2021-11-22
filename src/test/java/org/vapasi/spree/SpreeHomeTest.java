package org.vapasi.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;


public class SpreeHomeTest
{
    WebDriver driver;

    @BeforeMethod
    public void loadPage() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void assertCartValue()
    {
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.login(driver,"test14@gmail.com","test123");
        categoryPage.selectCategory();
        categoryPage.selectProduct();
        productPage.addProductToCart();
        cartPage.checkoutProduct();
        checkoutPage.addAddressDetail("Ulagammal","S","124,street12",
                "test city","22344","7890453456");
        checkoutPage.selectShippingMethod();
        checkoutPage.selectPaymentMethod();
String orderMessage = driver.findElement(By.className("alert")).getText();
Assert.assertEquals(orderMessage,"Your order has been processed successfully");
        System.out.println("Test Case passed");
       // String totalValue= driver.findElement(By.cssSelector("td[class='lead']")).getText();
        //System.out.println("The total value for the items in the cart is " +totalValue);
       /* boolean cartValue;
        if(totalValue == "")
            cartValue = false;
        else
            cartValue = true;
        Assert.assertTrue(cartValue);
       Assert.assertEquals(totalValue,"$47.97");
        System.out.println("The test passed");*/
    }

    @AfterMethod
    public void quitBrowser()
    {
      //  CartPage cartPage = new CartPage();
      //  cartPage.emptyCart(driver);
        driver.findElement(By.cssSelector("a[href='/logout']")).click();
        driver.quit();


    }
}

