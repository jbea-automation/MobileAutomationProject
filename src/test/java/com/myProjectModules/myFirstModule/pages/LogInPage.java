package com.myProjectModules.myFirstModule.pages;

import com.framework.ParentPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import static com.utility.Utility.getPropertyFrom;

public class LogInPage extends ParentPage {

    public LogInPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    //name of the project module
    private String location = "myFirstModule";
    //Locators
    private By TBX_emailOrUsername = By.id("com.spotify.music:id/username_text");
    private By TBX_password = By.id("com.spotify.music:id/password_text");
    private By BTN_logIn = By.id("com.spotify.music:id/login_button");
    private By LBL_logInErrorMessage = By.id("com.spotify.music:id/login_error_message");

    public void enterTheUserCredential(String userCredential) throws Throwable{
        if (userCredential.toLowerCase().contains("username"))
            fillElementWithValue(TBX_emailOrUsername, getPropertyFrom(userCredential, location));
        else
            fillElementWithValue(TBX_password, getPropertyFrom(userCredential, location));
    }

    public void clickOnLogInButton(){
        clickOnElement(BTN_logIn);
    }

    public String getLogInErrorMessage(){
        handlingWaitToElementBeClickeable(BTN_logIn);
        return getElementTextBy(LBL_logInErrorMessage);
    }

}
