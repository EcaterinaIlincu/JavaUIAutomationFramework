package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;


public class LoginPageSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
    @When("the login form is populated with the following details")
    public void theLoginFormIsPopulatedWithTheFollowingDetails(List<String> loginCredentials) {
        loginPage.fillInTheLoginForm(loginCredentials.get(0), loginCredentials.get(1));
    }

    @And("the login button is clicked")
    public void theLoginButtonIsClicked() {
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.clickTheLoginButton();
    }
}
