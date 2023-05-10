package com.qualityminds.seleniumframework.base;

import com.qualityminds.seleniumframework.wdm.DriverManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Slf4j
public abstract class BaseTest {

    private static final String BROWSER = "browser";
    private static final String HEADLESS = "headless";
    private static final BrowserType DEFAULT_BROWSER = BrowserType.CHROME;
    private static final boolean DEFAULT_HEADLESS = false;
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected final WebDriver driver() {
        return this.driver.get();
    }

    @Parameters({BROWSER, HEADLESS})
    @BeforeMethod(description = "Start driver...", alwaysRun = true)
    public void startDriver(@Optional String browser, @Optional String headless) {
        BrowserType myBrowser = BrowserType.valueOf(resolve(browser, BROWSER, DEFAULT_BROWSER));
        boolean myHeadless = Boolean.parseBoolean(resolve(headless, HEADLESS, DEFAULT_HEADLESS));
        driver.set(myHeadless
                ? DriverManagerFactory.getManager(myBrowser).createDriverHeadless()
                : DriverManagerFactory.getManager(myBrowser).createDriver());
        log.debug("Driver started.");
    }

    @AfterMethod(description = "Stop driver.", alwaysRun = true)
    public void stopDriver() {
        driver().quit();
        log.debug("Driver stopped.");
    }

    private <T> String resolve(String param, String prop, T defValue) {
        return isNullOrBlank(System.getProperty(prop))
                ? isNullOrBlank(param) ? String.valueOf(defValue) : param
                : System.getProperty(prop);
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
}
