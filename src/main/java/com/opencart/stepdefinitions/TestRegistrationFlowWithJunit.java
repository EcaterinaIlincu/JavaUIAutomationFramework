package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeAll
    public static void executeThisMethodBeforeAllTheTests() {
        System.out.println("The execution of the test suite has started");

    }

    @BeforeEach
    public void executeTheCodeBeforeEachTest() {
        System.out.println("This code is executed before each test case");
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.navigateToRegisterPageFromHeader();
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("The registration of a new user with valid data redirects to the Account page")
    public void registerWithValidCredentialsTest() throws InterruptedException {
        System.out.println("This is the test nr1");

        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();
        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generatedFirstName(), RandomDataManager.generateLastName(), randomEmail, password, true);
        registerPage.clickTheContinueButton();

        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        boolean doesTheCurrentUrlContainsSuccessAccountRoute = currentUrl.contains("route=account/success");

        Assertions.assertTrue(doesTheCurrentUrlContainsSuccessAccountRoute, "The current URL: " + currentUrl + "contains: route=account/success");
    }

    @Test
    @DisplayName("User is remaining on register page when trying to register with invalid password")
    public void registerWithInvalidPasswordTest() throws InterruptedException {
        System.out.println("This is the test nr2");

        String randomEmail = RandomDataManager.generateRandomEmail();

        System.out.println(randomEmail);

        registerPage.fillInTheRegisterForm(RandomDataManager.generatedFirstName(), RandomDataManager.generateLastName(), randomEmail, "1", true);
        registerPage.clickTheContinueButton();
        Thread.sleep(500);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";

        Assertions.assertEquals(expectedUrl, actualUrl, "The urls should be equal");

    }

    @Test
    @DisplayName("Error message is displayed on Register flow when password is less than 4 chars")
    public void errorMessageIsDisplayedWhenInvalidPassIsUsedForRegisterFlow() throws InterruptedException {
        System.out.println("This is the test nr3");

        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();

        System.out.println(randomEmail);

        registerPage.fillInTheRegisterForm(RandomDataManager.generatedFirstName(), RandomDataManager.generateLastName(), randomEmail, "As2", true);
        registerPage.clickTheContinueButton();
        Thread.sleep(500);

        String expectedErrorMessageForInvalidPassword = "Password must be between 4 and 20 characters!";
        String actualErrorMessage = driver.findElement(By.id("error-password")).getText();
        Assertions.assertEquals(expectedErrorMessageForInvalidPassword, actualErrorMessage);
    }

        @AfterEach
        public void executeAfterEachTestCase () {
            DriverManager.getInstance().tearDown();
            System.out.println("The test case execution has been finished");
        }

        @AfterAll
        public static void executeAfterAllTestCases () {
            System.out.println("The execution of test suite is finished");
        }

    }
