package com.qualityminds.seleniumframework.wdm;

import org.openqa.selenium.WebDriver;

public interface DriverManager {

    String CACHE_PATH = "drivers";

    WebDriver createDriver();

    WebDriver createDriverHeadless();
}
