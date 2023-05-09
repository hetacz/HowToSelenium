package com.qualityminds.seleniumframework.base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Slf4j
public class BasePage {

    private static final int FLUENT_WAIT = 30;
    private static final String HOME = "https://qualityminds.com";
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;
    protected final JavascriptExecutor js;
    private final By cookiesDiv = By.id("cmplz-cookiebanner-container");
    private final By closeCookiesBtn = By.cssSelector("div#cmplz-cookiebanner-container button.cmplz-accept");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    protected final void acceptCookies() {
        getVisibleElement(cookiesDiv);
        click(closeCookiesBtn);
    }

    protected final <T> void click(T locator) {
        getClickableElement(locator).click();
    }

    protected final <T> void jsClick(T locator) {
        js.executeScript("arguments[0].click();", getElement(locator));
    }

    protected final <T> void clear(T locator) {
        getClickableElement(locator).clear();
    }

    protected final <T> void type(T locator, CharSequence... text) {
        getClickableElement(locator).sendKeys(text);
    }

    protected final <T> String getText(T locator) {
        return getVisibleElement(locator).getText();
    }

    protected final void load(String url) {
        driver.get(HOME + url);
    }

    protected final void home() {
        driver.get(HOME);
    }

    protected final void logPageLoaded() {
        log.trace("{} page loaded", driver.getCurrentUrl());
    }

    protected final void waitForPageTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    protected final void waitForPageUrl(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }

    protected final <T> void hoverOver(T locator) {
        actions.moveToElement(getVisibleElement(locator)).pause(1_000).perform();
    }

    protected final <T> WebElement getElement(T locator) {
        return isBy(locator)
                ? getExistingElement((By) locator)
                : (WebElement) locator;
    }

    protected final <T> WebElement getClickableElement(T locator) {
        return wait.until(isBy(locator)
                ? ExpectedConditions.elementToBeClickable((By) locator)
                : ExpectedConditions.elementToBeClickable((WebElement) locator));
    }

    protected final <T> WebElement getVisibleElement(T locator) {
        return wait.until(isBy(locator)
                ? ExpectedConditions.visibilityOfElementLocated((By) locator)
                : ExpectedConditions.visibilityOf((WebElement) locator));
    }

    @SuppressWarnings("unchecked")
    protected final <T> List<WebElement> getVisibleElements(T locator) {
        return wait.until(isBy(locator)
                ? ExpectedConditions.visibilityOfAllElementsLocatedBy((By) locator)
                : ExpectedConditions.visibilityOfAllElements((List<WebElement>) locator));
    }

    protected final <T> Boolean waitForElementToDisappear(T locator) {
        return wait.until(isBy(locator)
                ? ExpectedConditions.invisibilityOfElementLocated((By) locator)
                : ExpectedConditions.invisibilityOf((WebElement) locator));
    }

    protected final WebElement getExistingElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected final void scrollDown() {
        js.executeScript("arguments[0].scrollIntoView(false)", driver.findElement(By.tagName("body")));
    }

    private <T> boolean isBy(T value) {
        return value.getClass().getName().contains("By");
    }
}
