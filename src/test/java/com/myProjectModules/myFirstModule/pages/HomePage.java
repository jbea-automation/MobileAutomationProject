package com.myProjectModules.myFirstModule.pages;

import com.framework.ParentPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends ParentPage {

    public HomePage (AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    private By BTN_settings = By.xpath("//android.widget.ImageButton[@content-desc='Settings']");

    public boolean verifyThatSettingButtonBeDisplayed(){
        return verifyIfElementIsDisplayed(BTN_settings);
    }

}
