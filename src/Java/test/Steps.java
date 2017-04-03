package test;

import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by VatslauX on 01-Apr-17.
 */
public class Steps {
    static final Logger rootLogger = LogManager.getRootLogger();
    public static void loginBox(String login, String password){
        rootLogger.info("Login BOX");
        Selenide.open(Page.boxLoginURL);
        sleep(6000);
        if(Page.BOX_BTN_SIGN_IN.isDisplayed()) {
            submitCredentials(login, password);
        }
    }
    public static void loginBox(String targetFolderUrl, String login, String password){
        rootLogger.info("Login BOX");
        if(targetFolderUrl!=null){
        open(targetFolderUrl);}
        if(targetFolderUrl==null){
            rootLogger.info("Login url not defined");
            return;
        }
        sleep(6000);
        if(Page.BOX_BTN_SIGN_IN.isDisplayed()) {
            submitCredentials(login, password);
        }
    }
    public static void submitCredentials(String login, String password){
        if(login!=null) {
            Page.boxWindowEmail.sendKeys(login);
        }
        if(password!=null) {
            Page.boxWindowPassword.sendKeys(password);
        }
        Page.BOX_BTN_SIGN_IN.click();
        rootLogger.info("Login form submitted");
        sleep(4000);
        return;
    }
}
