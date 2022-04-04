package com.cydeo.library.utilities;

import com.cydeo.library.POM.LoginPage;

public class CredentialsUtils {
    LoginPage loginPage = new LoginPage();
    public static void loginAsStudent(String username, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

    }
}
