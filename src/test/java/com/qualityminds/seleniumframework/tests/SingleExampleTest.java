package com.qualityminds.seleniumframework.tests;

import com.qualityminds.seleniumframework.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class SingleExampleTest extends BaseTest {

    @Test
    public void aloneTest() {
        driver().get("https://www.qualityminds.de/");
        log.info("Alone test case");
    }
}
