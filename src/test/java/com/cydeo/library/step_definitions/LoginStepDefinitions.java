package com.cydeo.library.step_definitions;

import com.cydeo.library.POM.LandingPage;
import com.cydeo.library.POM.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import com.cydeo.library.utilities.Waiter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    Waiter waiter = new Waiter(Driver.getDriver());
    LandingPage landingPage = new LandingPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("librarianUID1"));
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("librarianPW1"));
        loginPage.signInBTN.click();
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        String expected = "dashboard";
        waiter.waitForGetUrl(expected, 5);
        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));

        Driver.closeDriver();
    }
    @When("user enters student username")
    public void user_enters_student_username() {
       loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("studentUID1"));
    }
    @When("user enters student password")
    public void user_enters_student_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("studentPW1"));
        loginPage.signInBTN.click();
    }
    @Then("user should see the Books")
    public void user_should_see_the_main() {
        String expected = "books";
        waiter.waitForGetUrl(expected, 5);
        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }

    @When("user enters librarian username {string}")
    public void userEntersLibrarianUsername(String username) {
    loginPage.emailInput.sendKeys(username);
    }

    @And("user enters librarian password {string}")
    public void userEntersLibrarianPassword(String password) {
    loginPage.passwordInput.sendKeys(password);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
     loginPage.signInBTN.click();
    }
    @Then("there should be {int} users")
    public void there_should_be_users(Integer users) {
    int expectedUsersNumber = users;
    String expected = String.valueOf(expectedUsersNumber);
    String actual = landingPage.userCount.getText();
        System.out.println("actual = " + actual);
        BrowserUtils.sleep(3);
        Assert.assertEquals(actual, expected);
    }


    @When("user enters librarian {string} and {string}")
    public void userEntersLibrarianAnd(String username, String password) {
        loginPage.login(username, password);
    }
}
