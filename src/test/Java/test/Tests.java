package test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static test.Steps.loginBox;

/**
 * Created by VatslauX on 01-Apr-17.
 */
public class Tests {
    static final Logger rootLogger = LogManager.getRootLogger();
    private String OWNER_EMAIL;
    private String OWNER_BOX_PASSWORD;
    @Test
    public void login(){
        FirefoxDriverManager.getInstance().setup();
        loginBox(OWNER_EMAIL, OWNER_BOX_PASSWORD);
   }
}
