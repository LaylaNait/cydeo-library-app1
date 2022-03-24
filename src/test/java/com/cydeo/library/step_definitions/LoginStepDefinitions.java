package com.cydeo.library.step_definitions;

import com.cydeo.library.POM.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage(Driver.getDriver());

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user enters {string} username")
    public void user_enters_librarian_username() {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("studentUID1"));
    }
    @When("user enters {string} password")
    public void user_enters_librarian_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("studentPW1"));
        loginPage.signInBTN.click();
    }
    @Then("user should see the {string}")
    public void user_should_see_the_dashboard() {

       // loginPage.loginAsLibrarian();
        Assert.assertTrue(loginPage.mainPage.isDisplayed());
    }

    @When("user enters {string} username")
    public void user_enters_student_username() {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("librarianUID1"));
    }
    @When("user enters {string} password")
    public void user_enters_student_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("librarianPW1"));
        loginPage.signInBTN.click();

    }

    @Then("user should see the Main")
    public void userShouldSeeTheMain() {
       // loginPage.loginAsStudent();
        Assert.assertTrue(loginPage.dashboard.isDisplayed());

    }
}
