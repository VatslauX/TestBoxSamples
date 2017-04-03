package Java.Test;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static Java.Test.Page.boxLoginURL;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.WebDriverRunner.*;



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
        Selenide.open(boxLoginURL);
        Assert.assertTrue(Page.boxWindowEmail.isDisplayed()==true);
        Assert.assertTrue(Page.boxWindowPassword.isDisplayed()==true);
    }
    @Test
    public void login(){
        Steps.loginBox(OWNER_EMAIL, OWNER_BOX_PASSWORD);
        Assert.assertTrue(Page.boxNoFilesPlaceholder.isDisplayed()==true);
    }
    @Test
    public void loginSpecificFolder1(){
        Steps.loginBox(FOLDER_URL, OWNER_EMAIL, OWNER_BOX_PASSWORD);
        Assert.assertTrue(Page.boxNoFilesPlaceholder.isDisplayed()==true);
    }
    @Test
    public void loginSpecificFolder2(){
        Steps.loginBox(null, OWNER_EMAIL, OWNER_BOX_PASSWORD);
        Assert.assertTrue(Page.boxNoFilesPlaceholder.isDisplayed()==true);
    }
    @Test
    public void loginSpecificFolder3(){
        Steps.loginBox(FOLDER_URL, null, OWNER_BOX_PASSWORD);
        Assert.assertTrue(Page.boxNoFilesPlaceholder.isDisplayed()==true);
    }
    @Test
    public void loginSpecificFolder4(){
        Steps.loginBox(FOLDER_URL, OWNER_EMAIL, null);
        Assert.assertTrue(Page.boxNoFilesPlaceholder.isDisplayed()==true);
    }

}
