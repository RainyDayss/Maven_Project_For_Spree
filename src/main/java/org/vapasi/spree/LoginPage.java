package org.vapasi.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    @FindBy(id = "spree_user_email")
    private WebElement emailTextBox;

    @FindBy(name = "spree_user[password]")
    private WebElement passwordTextBox;

    @FindBy(css = "input[id='spree_user_remember_me']")
    private WebElement rememberMe;

    @FindBy(css = "input[value='Login']")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(WebDriver driver,String emailId,String password)
    {
        emailTextBox.sendKeys(emailId);
        passwordTextBox.sendKeys(password);
        submit.click();

    }
}

