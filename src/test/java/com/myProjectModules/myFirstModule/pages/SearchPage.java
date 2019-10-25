package com.myProjectModules.myFirstModule.pages;

import com.framework.ParentPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

public class SearchPage extends ParentPage {

    public SearchPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    private By BTN_searchNavigation = By.id("com.spotify.music:id/search_tab");
    private By LBL_tittleSearchPage = By.id("com.spotify.music:id/header_title");
    private By TBX_searchOption = By.id("com.spotify.music:id/find_search_field");
    private By TBX_searchText = By.id("com.spotify.music:id/query");
    private By LBL_nameOfSongs = By.id("android:id/text1");

    public void clickOnSearchNavigationButton(){
        clickOnElement(BTN_searchNavigation);
    }

    public String getTittleFromSearchPage(){
        return getElementTextBy(LBL_tittleSearchPage);
    }

    public String getPlaceHolderFromSearchTextBox(){
        return getElementTextBy(TBX_searchOption);
    }

    public void enterTextToSearch(String textToSearch){
        clearTextFromElement(TBX_searchOption);
        fillElementWithValue(TBX_searchText, textToSearch);
    }

    /**
     * method to verify all the results displayed after do a search by text
     * the conditional -2 in the for sentence is due we have 2 elements what share the same id
     * that are for display all the artist and the other is for display all the songs
     * @param textToSearch
     * @return
     */
    public boolean verifyAllResultsContainsTheWordSearched(String textToSearch){
        List<AndroidElement> nameOfSongs = getListOfElementFromLocator(LBL_nameOfSongs);
        for (int i=0; i  < getTotalOfElementsFound(LBL_nameOfSongs) - 2; i ++) {
            if ((nameOfSongs.get(i).getText()).toLowerCase().contains(textToSearch.toLowerCase()) ){
                i ++;
            }
            else
                return false;
        }
        return true;
    }

}
