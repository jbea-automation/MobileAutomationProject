package com.myProjectModules.myFirstModule.steps;

import com.myProjectModules.myFirstModule.AppTestRun;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps extends AppTestRun {

    @Given("^an user access to the spotify application$")
    public void anUserAccessToTheSpotifyApplication() {
        //Uncomment this steps if you want to run this feature using cucumber runner
        //startAndroid();
    }

    @When("^the main page be loaded successfully$")
    public void theMainPageBeLoadedSuccessfully() {
        mainPage.waitForAppBeLoaded();
    }

    @Then("^verify that the spotify logo icon be displayed$")
    public void verifyThatTheSpotifyLogoIconBeDisplayed() {
        Assert.assertTrue(mainPage.verifyIfTheSpotifyLogoIsDisplayed());
    }

    @And("^do click in log in button$")
    public void doClickInLogInButton() {
        mainPage.clickOnLogInOption();
    }

    @Given("^an user be in the login page$")
    public void anUserBeInTheLoginPage() {
        anUserAccessToTheSpotifyApplication();
        theMainPageBeLoadedSuccessfully();
        doClickInLogInButton();
    }

    @When("^the user enter his user credential \"([^\"]*)\"$")
    public void theUserEnterHisUserCredential(String userCredential) throws Throwable {
        logInPage.enterTheUserCredential(userCredential);
    }

    @And("^the user do click on login button$")
    public void theUserDoClickOnLoginButton() {
        logInPage.clickOnLogInButton();
    }

    @Then("^verify that the following error message be displayed \"([^\"]*)\"$")
    public void verifyThatTheFollowingErrorMessageBeDisplayed(String loginErrorMessage) {
        Assert.assertEquals(loginErrorMessage, logInPage.getLogInErrorMessage());
    }

    @Then("^verify that the setting button be displayed into the home page$")
    public void verifyThatTheSettingButtonBeDisplayedIntoTheHomePage(){
        homePage.verifyThatSettingButtonBeDisplayed();
    }

    @Given("^an user be already logged into the application$")
    public void anUserBeAlreadyLoggedIntoTheApplication(DataTable userCredentialsTable) throws Throwable {
        beforeScenario();
        List<Map<String, String>> listOfCredentials = userCredentialsTable.asMaps(String.class, String.class);
        anUserBeInTheLoginPage();
        theUserEnterHisUserCredential(listOfCredentials.get(0).get("userName"));
        theUserEnterHisUserCredential(listOfCredentials.get(0).get("password"));
        theUserDoClickOnLoginButton();
    }

}
