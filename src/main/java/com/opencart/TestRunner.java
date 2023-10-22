package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        //save the window name
        String currentWindowName = driver.getWindowHandle();

        // New Window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https:/opencart.antropy.co.uk/");
        Thread.sleep(2000);

        //Find element by xpath
        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa fa-user']"));

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

        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));
        phoneInput.sendKeys(RandomDataManager.generatePhoneNumber());

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);

        WebElement confirmPassword = driver.findElement(By.cssSelector("#input-confirm"));
        confirmPassword.sendKeys(password);
        System.out.println(password);

        WebElement termsAndConditionsCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
        termsAndConditionsCheckbox.click();

        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Continue']"));
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