package com.qualityminds.seleniumframework.wdm;


import com.qualityminds.seleniumframework.base.BrowserType;
import com.qualityminds.seleniumframework.wdm.driver.ChromeDM;
import com.qualityminds.seleniumframework.wdm.driver.EdgeDM;
import com.qualityminds.seleniumframework.wdm.driver.FirefoxDM;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DriverManagerFactory {

    public DriverManager getManager(BrowserType browserType) {
        return switch (browserType) {
            case CHROME -> new ChromeDM();
            case FIREFOX -> new FirefoxDM();
            case EDGE -> new EdgeDM();
        };
    }
}
