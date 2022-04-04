package com.cydeo.library.step_definitions;

import com.cydeo.library.POM.LandingPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UsersTableStepDefs {
    LandingPage landingPage = new LandingPage();
    @Then("table should have following column name:")
    public void table_should_have_following_column_name(List<String> columnNames) {
        List<String> columnsList = new ArrayList<>();
        for (WebElement e : landingPage.tableColumns)
            columnsList.add(e.getText());

        Assert.assertEquals(columnNames, columnsList);
    }
    }

