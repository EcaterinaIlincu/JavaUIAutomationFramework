package com.opencart.stepdefinitions;

import com.opencart.managers.ConfigReaderManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homepage = new HomePage(driver);

    private static final Logger logger = LogManager.getLogger(HomePageSteps.class);

    @Given("HomePage is displayed")
    public void homepageIsDisplayed() {
        driver.get(ConfigReaderManager.getPropertyValue("url"));
        logger.log(Level.INFO,"The driver accessed the home page");
    }

    @When("registerLink from Header menu is clicked")
    public void registerLinkFromHeaderMenuIsClicked() {
        homepage.navigateToRegisterPageFromHeader();
        logger.log(Level.INFO,"he Register Link has been accessed from the header menu");
    }
}
