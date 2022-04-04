package com.cydeo.library.POM;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import com.cydeo.library.utilities.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  BasePage{
    Waiter waiter = new Waiter(Driver.getDriver());

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(xpath = "//input[@id='inputEmail']")
        public WebElement emailInput;

        @FindBy(xpath = "//input[@id='inputPassword']")
        public WebElement passwordInput;

        @FindBy(xpath = "//button[@type='submit']")
        public  WebElement signInBTN;

        @FindBy(xpath = "//main[@id='spapp']")
        public  WebElement mainPage;

        @FindBy(xpath = "//a[@href='#dashboard']")
        public WebElement dashboard;

        public void login (String username, String password) {
            emailInput.clear();
            waiter.waitForElement(emailInput, 2);
            emailInput.sendKeys(username);
            passwordInput.clear();
            waiter.waitForElement(passwordInput, 2);
            passwordInput.sendKeys(password);
            signInBTN.click();
        }
    public void loginAsStudent(){
        emailInput.sendKeys(ConfigurationReader.getProperty("studentUID2"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("studentPW2"));
        signInBTN.click();
    }

        public void loginAsLibrarian(){
            emailInput.sendKeys(ConfigurationReader.getProperty("librarianUID2"));
            passwordInput.sendKeys(ConfigurationReader.getProperty("librarianPW2"));
            signInBTN.click();
        }
}
