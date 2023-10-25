package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        //save the window name
        String currentWindowName = driver.getWindowHandle();

        // New Window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host");
        Thread.sleep(2000);

        //Find element by xpath
        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));

        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));

        registerOption.click();
        System.out.println(driver.getCurrentUrl());

        //Find element by id

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));

        //add value in the field
        String firstName = RandomDataManager.generatedFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);

        //Find element by css selector

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataManager.generateLastName();
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataManager.generateRandomEmail();
        emailInput.sendKeys(randomEmail);


        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);
        System.out.println(password);

        WebElement registerButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        WebElement termsAndConditionsToggleBar = driver.findElement(By.xpath("//input[@name='agree']"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", termsAndConditionsToggleBar);
        Thread.sleep(3000);
        termsAndConditionsToggleBar.click();

        registerButton.click();


        Thread.sleep(5000);

        System.out.println(driver.getTitle());
        driver.close(); // inchide tab
        //switch to first window that was saved in "Current window name"
        driver.switchTo().window(currentWindowName);
        driver.get("https://www.tekwill.md/");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.quit(); // inchide instanta

        System.out.println("The execution is over");





    }
}