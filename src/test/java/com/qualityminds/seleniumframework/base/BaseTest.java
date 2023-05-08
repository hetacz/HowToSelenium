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
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected final WebDriver driver() {
        return this.driver.get();
    }

    @Parameters({BROWSER, HEADLESS})
    @BeforeMethod(description = "Start driver...", alwaysRun = true)
    public void startDriver(@Optional String browser, @Optional String headless) {
        log.warn("Browser: {}", browser);
        log.warn("Headless: {}", headless);
        driver.set(Boolean.parseBoolean(headless)
                ? DriverManagerFactory.getManager(BrowserType.valueOf(browser)).createDriverHeadless()
                : DriverManagerFactory.getManager(BrowserType.valueOf(browser)).createDriver());
        log.debug("Driver started.");
    }

    @Parameters(BROWSER)
    @AfterMethod(description = "Stop driver.", alwaysRun = true)
    public void stopDriver() {
        driver().quit();
        log.debug("Driver stopped.");
    }
}
