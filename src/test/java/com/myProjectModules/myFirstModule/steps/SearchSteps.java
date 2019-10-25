package com.myProjectModules.myFirstModule.steps;

import com.myProjectModules.myFirstModule.AppTestRun;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SearchSteps extends AppTestRun {
    @When("^the user do click on the navigation Search button$")
    public void theUserDoClickOnTheNavigationSearchButton() {
        searchPage.clickOnSearchNavigationButton();
    }

    @And("^the user enters the word \"([^\"]*)\" in the search field$")
    public void theUserEntersTheWordInTheSearchField(String textToSearch) {
        searchPage.enterTextToSearch(textToSearch);
    }

    @Then("^the application should display only result that contains the \"([^\"]*)\" entered$")
    public void theApplicationShouldDisplayOnlyResultThatContainsTheEntered(String textToSearch) {
        Assert.assertTrue(searchPage.verifyAllResultsContainsTheWordSearched(textToSearch));
    }
}
