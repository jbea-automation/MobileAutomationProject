package com.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public abstract class BasePage{
    private AppiumDriver appiumDriver;
    private JavascriptExecutor js = (JavascriptExecutor) appiumDriver;

    public BasePage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    /** Click in some element (Locator)
     * This method is use for do click in any Element
     * @param locator
     */
    public void clickOnElement (By locator){
        appiumDriver.findElement(locator).click();
    }

    /** Click in some element (Locator)
     * This method is use for do click in any Element
     * @param locator
     */
    public void clickOnElement (String locator){
        String jQuerySelector = "return $(\"" + locator + "\").get(0);";
        WebElement element = (WebElement) js.executeScript(jQuerySelector);
        element.click();
    }

    public void clearTextFromElement (By locator){
        appiumDriver.findElement(locator).clear();
    }

    public void fillElementWithValue(By locator, String text){
        appiumDriver.findElement(locator).clear();
        appiumDriver.findElement(locator).sendKeys(text);
    }

    public void fillElementWithValueAndDoEnter(By locator, String text){
        WebElement element =  appiumDriver.findElement(locator);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public String getElementTextBy (By locator){
        return appiumDriver.findElement(locator).getText();
    }

    /**
     * This a method to wait for an Element
     * @param locator
     */
    public void handlingWaitToElement(By locator){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void handlingWaitToElementBeClickeable(By locator){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void handlingWaitToElement(By locator1, By locator2){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 60);
        By newLocator = By.xpath(locator1.toString().replaceAll("(By.xpath: )|(.*?)", "")
                + locator2.toString().replaceAll("(By.xpath: )|(.*?)", ""));
        wait.until(ExpectedConditions.presenceOfElementLocated(newLocator));
    }

    /**
     * This a method for do a click on one element with a specific text
     * this method contain a handling wait by new element
     * @param  locator
     * @param  textValue
     **/
    public void clickElementByTextValue(By locator, String textValue)
    {
        By newLocator = By.id(locator.toString().replaceAll("(By.id: )|(.*?)", "")
                + textValue);
        clickOnElement(newLocator);
    }

    public void selectComboBoxFieldByText(By locator, String textValue){
        appiumDriver.findElement(locator).click();
        By newLocator = By.xpath(locator.toString().replaceAll("(By.xpath: )|(.*?)", "") +
                "/..//*[text()='" + textValue + "']");
        handlingWaitToElement(newLocator);
        clickOnElement(newLocator);
    }

    public void waitBlockedMigrationProcessCUpS(By locator1, By locator2){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 60);

        By inProgress = By.xpath(locator1.toString().replaceAll("(By.xpath: )|(.*?)", "")
                + locator2.toString().replaceAll("(By.xpath: )", "").replaceAll("(?<=')[^']+(?=')","In progress"));
        wait.until(ExpectedConditions.presenceOfElementLocated(inProgress));

        By blocked = By.xpath(locator1.toString().replaceAll("(By.xpath: )|(.*?)", "")
                + locator2.toString().replaceAll("(By.xpath: )", "").replaceAll("(?<=')[^']+(?=')","Blocked"));
        wait.until(ExpectedConditions.presenceOfElementLocated(blocked));
    }

    public boolean verifyIfElementIsEnabled(By locator){
        return appiumDriver.findElement(locator).isEnabled();
    }

    public boolean verifyIfElementIsDisplayed(By locator){
        return appiumDriver.findElement(locator).isDisplayed();
    }

    public int getTotalOfElementsFound(By locator){
        return appiumDriver.findElements(locator).size();
    }

    /**
     * Waits for and finds a list of elements by their appium selector
     * @param locator appium selector of the elements
     * @return List of all the found elements
     */
    public List<AndroidElement> getListOfElementFromLocator(By locator) {
        return (List<AndroidElement>) appiumDriver.findElements(locator);
    }

    public void changeToSecondTab() {
        Set<String> handles = appiumDriver.getWindowHandles();
        String currentHandle = appiumDriver.getWindowHandle();
        for (String handle : handles) {
            if (!handle.equals(currentHandle)) {
                appiumDriver.switchTo().window(handle);
            }else{
                appiumDriver.close();
            }
        }
    }

}
