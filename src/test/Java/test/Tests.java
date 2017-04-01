package test;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.MARIONETTE;
import static test.Steps.loginBox;

/**
 * Created by VatslauX on 01-Apr-17.
 */
public class Tests {
    static final Logger rootLogger = LogManager.getRootLogger();
    private String OWNER_EMAIL = "";
    private String OWNER_BOX_PASSWORD = "";

    @BeforeClass
    public static void beforeClass(){

   }
    @Before
    public void before(){}

    @Test
    public void login(){
        browser = CHROME;
        startMaximized =false;
        ChromeDriverManager.getInstance().setup();
        loginBox(OWNER_EMAIL, OWNER_BOX_PASSWORD);
   }
}
