package com.qualityminds.seleniumframework.wdm.driver;

import com.qualityminds.seleniumframework.wdm.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDM implements DriverManager {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().cachePath(DriverManager.CACHE_PATH).setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public WebDriver createDriverHeadless() {
        WebDriverManager.edgedriver().cachePath(DriverManager.CACHE_PATH).setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--window-size=1920,1080", "--headless=new");
        return new EdgeDriver(options);
    }
}
