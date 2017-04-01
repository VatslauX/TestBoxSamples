package test;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

import static test.Page.*;
import static test.Steps.loginBox;

/**
 * Created by VatslauX on 01-Apr-17.
 */
public class Tests {
    static final Logger rootLogger = LogManager.getRootLogger();
    private String OWNER_EMAIL = "";
    private String OWNER_BOX_PASSWORD = "";
    private String FOLDER_URL = "";

    @Before
    public void before(){
        browser = CHROME;
        startMaximized =false;
        ChromeDriverManager.getInstance().setup();
    }
    @Test
    public void openUrl(){
        open(boxLoginURL);
        Assert.assertTrue(boxWindowEmail.isDisplayed()==true);
        Assert.assertTrue(boxWindowPassword.isDisplayed()==true);
    }
    @Test
    public void login(){
        loginBox(OWNER_EMAIL, OWNER_BOX_PASSWORD);
        Assert.assertTrue(boxNoFilesPlaceholder.isDisplayed()==true);
    }
    @Test
    public void loginSpecificFolder(){
        loginBox(FOLDER_URL, OWNER_EMAIL, OWNER_BOX_PASSWORD);
        Assert.assertTrue(boxNoFilesPlaceholder.isDisplayed()==true);
    }
}
