package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();
        //save the window name
        String currentWindowName = driver.getWindowHandle();
        // New Window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
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