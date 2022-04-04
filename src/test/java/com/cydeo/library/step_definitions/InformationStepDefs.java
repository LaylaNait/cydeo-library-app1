package com.cydeo.library.step_definitions;

import com.cydeo.library.POM.LandingPage;
import com.cydeo.library.POM.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import com.cydeo.library.utilities.Waiter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InformationStepDefs {
    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();
    Waiter waiter = new Waiter(Driver.getDriver());

    @Given("user is on the login page in {string}")
    public void userIsOnTheLoginPageIn(String env2) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
    }
    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.emailInput.clear();
        waiter.waitForElement(loginPage.emailInput, 2);
        loginPage.emailInput.sendKeys(username);
        loginPage.passwordInput.clear();
        waiter.waitForElement(loginPage.passwordInput, 2);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInBTN.click();
    }
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String name)    {
        landingPage.names.click();
        BrowserUtils.sleep(3);
        Assert.assertEquals(name, landingPage.names.getText());
    }


}
