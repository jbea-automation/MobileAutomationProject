package com.myProjectModules.myFirstModule.pages;

import com.framework.ParentPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainPage extends ParentPage {

    public MainPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    private By IMG_spotifyLogo = By.id("com.spotify.music:id/spotify_logo");
    private By BTN_signUpFree = By.id("com.spotify.music:id/button_signup");
    private By BTN_continueWithFaceBook = By.id("com.spotify.music:id/button_facebook");
    private By BTN_logIn = By.id("com.spotify.music:id/button_login");

    public void waitForAppBeLoaded(){
        handlingWaitToElement(IMG_spotifyLogo);
    }

    public boolean verifyIfTheSpotifyLogoIsDisplayed(){
       return verifyIfElementIsDisplayed(IMG_spotifyLogo);
    }

    public void clickOnSignUpFreeOption(){
        clickOnElement(BTN_signUpFree);
    }

    public void clickOnContinueWithFaceBookOption(){
        clickOnElement(BTN_continueWithFaceBook);
    }

    public void clickOnLogInOption(){
        clickOnElement(BTN_logIn);
    }

}
