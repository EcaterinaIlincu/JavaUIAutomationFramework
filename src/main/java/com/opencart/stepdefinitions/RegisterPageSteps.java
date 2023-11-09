package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() {
        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();
        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generatedFirstName(), RandomDataManager.generateLastName(), randomEmail, password, true);
        System.out.println("The register form is populated with valid random data");
    }

    @And("Continue button is clicked")
    public void continueButtonIsClicked() {
        registerPage.clickTheContinueButton();
        System.out.println("The continue button has been clicked");
    }

    @And("the register form is populated with the following data:")
    public void theRegisterFormIsPopulatedWithTheFollowingData(Map<String, String> formDataMap) {
        String firstNameValue = formDataMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")){
            firstNameValue = RandomDataManager.generatedFirstName();
        }
        String lastNameValue = formDataMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = RandomDataManager.generateLastName();
        }
        String emailValue = formDataMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")) {
            emailValue = RandomDataManager.generateRandomEmail();
        }
        String passwordValue = formDataMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")) {
            passwordValue = RandomDataManager.generatePassword();
        }
      registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue, true);
    }

}
