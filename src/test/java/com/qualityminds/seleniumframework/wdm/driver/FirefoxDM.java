package com.qualityminds.seleniumframework.wdm.driver;


import com.qualityminds.seleniumframework.wdm.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDM implements DriverManager {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().cachePath(DriverManager.CACHE_PATH).setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public WebDriver createDriverHeadless() {
        WebDriverManager.firefoxdriver().cachePath(DriverManager.CACHE_PATH).setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless", "-width 1920", "-height 1080");
        return new FirefoxDriver(options);
    }
}
