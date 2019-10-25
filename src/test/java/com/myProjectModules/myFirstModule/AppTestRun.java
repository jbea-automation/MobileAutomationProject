package com.myProjectModules.myFirstModule;

import com.framework.ParentScenario;
import com.myProjectModules.myFirstModule.pages.HomePage;
import com.myProjectModules.myFirstModule.pages.LogInPage;
import com.myProjectModules.myFirstModule.pages.MainPage;
import com.myProjectModules.myFirstModule.pages.SearchPage;
import cucumber.api.java.After;
import io.appium.java_client.AppiumDriver;
import cucumber.api.CucumberOptions;

@CucumberOptions(plugin = {"pretty",
        "json:target/cucumber_json_reports/home-page.json",
        "json:target/cucumber.json",
        "html:target/home-page-html"},
  features = {"src/test/resources/features/myFirstModule/"},
  tags = "@test",
  glue = { "com.myProjectModules.myFirstModule.steps"})

public class AppTestRun extends ParentScenario {

  //SpotifyPages
  protected static MainPage mainPage;
  protected static LogInPage logInPage;
  protected static HomePage homePage;
  protected static SearchPage searchPage;

  @Override
  public void initPages(AppiumDriver appiumDriver)
  {
      mainPage = new MainPage(appiumDriver);
      logInPage = new LogInPage(appiumDriver);
      homePage = new HomePage(appiumDriver);
      searchPage = new SearchPage(appiumDriver);
  }

}
