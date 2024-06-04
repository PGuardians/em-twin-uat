package com.utils;

import org.openqa.selenium.WebDriver;

public class BaseClass_Driver_Methods {
    

    public static void urlLaunch(String Url,WebDriver driver) {
        driver.navigate().to(Url);
    }

    public static void getTitle(WebDriver driver) {
        driver.getTitle();
    }

    public static void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }

    public static void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public static void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    public static void closeCurrentWindow(WebDriver driver) {
        driver.close();
    }

    public static void closeAllWindow(WebDriver driver) {
        driver.quit();
    }

    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static void gettextAlert(WebDriver driver) {
        driver.switchTo().alert().getText();
    }

    public static void sendkeysAlert(String message,WebDriver driver) {
        driver.switchTo().alert().sendKeys(message);
    }
}
