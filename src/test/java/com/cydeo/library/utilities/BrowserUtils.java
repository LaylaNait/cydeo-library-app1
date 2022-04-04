package com.cydeo.library.utilities;

import com.cydeo.library.POM.BasePage;
import com.cydeo.library.POM.LandingPage;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }
    public static List<String> getElementText (List<WebElement> list){
        List<String> elemTexts = new ArrayList<>();
        for (WebElement element : list) {
            elemTexts.add(element.getText());
        }
        return elemTexts;
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options text in a list of String
     * @param dropDownElement
     * @return List<String> actualOptionsAsString
     */

    public static List<String> convertDropDownOptionsAsString (WebElement dropDownElement){
        Select select = new Select(dropDownElement);

        //List of all Actual month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all Actual month <options> as a string
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    Waiter waiter = new Waiter(Driver.getDriver());
    LandingPage landingPage =new LandingPage();
    /**
     * Clicks an item identified by its name (String) among a list (WebElements)
     * @param driver : WebDriver
     * @param waiter : Waiter
     * @param wl : list of web elements
     * @param name : string identifying the item
     */
    public static void clickItem(WebDriver driver, Waiter waiter, List<WebElement> wl, String name){
        Actions a = new Actions(driver);
        a.moveToElement(wl.get(0)).perform();
        for (int i = 0; i < wl.size(); i++){
            waiter.fluentWaitForElement(wl.get(i));
            a.moveToElement(wl.get(i)).perform();
            if (wl.get(i).getText().equals(name)){
                wl.get(i).click();
                break;
            }
        }}
        @When("user clicks the {string} module")
        public void user_clicks_the_module(String module) {

            clickItem(Driver.getDriver(), waiter, landingPage.libraryMainModuleLink, module);
        }

}

