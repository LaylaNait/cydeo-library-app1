package com.cydeo.library.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public  WebDriver driver;

    public Waiter(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElement(WebElement element, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement(By locator, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(WebElement element, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
