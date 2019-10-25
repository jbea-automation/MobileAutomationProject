package com.framework;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class ParentScenario extends AbstractTestNGCucumberTests {
    static private AppiumDriver appiumDriver;

    @BeforeClass
    @Parameters({ "device" })
    public void startApplication(String browser){
        switch (browser){
            case "android":
                startAndroid();
                break;
            case "ios":
                startIOs();
                break;
        }
    }

    public RemoteWebDriver startAndroid(){
        String url = "http://localhost:4723/wd/hub";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.spotify.music");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.spotify.music.MainActivity");

        try{
            appiumDriver = new AndroidDriver<MobileElement>(new URL(url),cap);
            appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            initPages(appiumDriver);

        }catch (Exception e){
            System.out.println("Exception at moment to generate the driver: " + e);
        }
        return appiumDriver;
    }

    public RemoteWebDriver startIOs(){
        String url = "http://localhost:4723/wd/hub";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 8");
        cap.setCapability(MobileCapabilityType.UDID,"FFB4FC51-F415-4203-8FD1-8ADADBA789DC");
        cap.setCapability(MobileCapabilityType.APP, "/Users/bestrada/Downloads/PetMatch.app");
        try{
            appiumDriver = new IOSDriver(new URL(url),cap);
            appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            initPages(appiumDriver);
        }catch (Exception e){
            System.out.println("Exception at moment to generate the driver: " + e);
        }
        return appiumDriver;
    }

    public abstract void initPages(AppiumDriver appiumDriver);

    public void navigateTo (String url){
        appiumDriver.navigate().to(url);
    }

    public void beforeScenario(){
        appiumDriver.resetApp();
    }

    @AfterClass
    public void closeDriver(){
        appiumDriver.quit();
    }


}
