package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath ="//input[@id='input-email']")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
    private WebElement logoutBtn;



    public void fillInTheLoginForm(String email, String password){
        emailAddressInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void clickTheLoginButton(){
        loginBtn.click();
    }

    public void clickTheLogoutButton(){
        myAccountIcon.click();
        logoutBtn.click();
    }


}
