package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);


}
