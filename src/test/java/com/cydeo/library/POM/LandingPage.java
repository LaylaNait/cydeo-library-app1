package com.cydeo.library.POM;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage  extends BasePage{
    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id= "user_count")
    public WebElement userCount;

    @FindBy(xpath = "//*[@id=\"tbl_users\"]/thead/tr/th")
    public List<WebElement> tableColumns;

    @FindBy(xpath = "//*[@id='navbarDropdown']/span")
    public WebElement names;
}
