package com.qualityminds.seleniumframework.tests;

import com.qualityminds.seleniumframework.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class ExampleTest extends BaseTest {

    @Test
    public void testCase1() {
        driver().get("https://www.qualityminds.de/");
        log.info("Test case 1");
    }

    @Test
    public void testCase2() {
        driver().get("https://www.qualityminds.de/");
        log.info("Test case 2");
    }
}
