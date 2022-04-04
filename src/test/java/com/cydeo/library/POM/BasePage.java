package com.cydeo.library.POM;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"menu_item\"]/li[contains(.,'')]")
    public List<WebElement> libraryMainModuleLink;

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordsDropDown;
}
