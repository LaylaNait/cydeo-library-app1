package com.cydeo.library.step_definitions;

import com.cydeo.library.POM.BasePage;
import com.cydeo.library.POM.LandingPage;
import com.cydeo.library.POM.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.Driver;
import com.cydeo.library.utilities.Waiter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PageNavigationsStepDefs {
    LoginPage loginPage = new LoginPage(Driver.getDriver());
    LandingPage landingPage   = new LandingPage();
    Waiter waiter = new Waiter(Driver.getDriver());
    Select select;

    @When("user click on {string} link")
    public void user_click_on_link(String users) {
        BrowserUtils.clickItem(Driver.getDriver(), waiter, landingPage.libraryMainModuleLink, users);
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer num) {
        waiter.waitForElement(landingPage.showRecordsDropDown,5);
       select  = new Select(landingPage.showRecordsDropDown);
      String actual  = select.getFirstSelectedOption().getText();
      Assert.assertEquals(num+"", actual);

    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
       select = new Select(landingPage.showRecordsDropDown);
       List<WebElement> webElements = select.getOptions();
       List<String> actualText = BrowserUtils.getElementText(webElements);
       Assert.assertEquals(options,actualText);

    }


}
