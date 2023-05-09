package com.qualityminds.seleniumframework.tests;

import com.qualityminds.seleniumframework.base.BaseTest;
import com.qualityminds.seleniumframework.page.HomePagePO;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class ExampleTest extends BaseTest {

    @Test
    public void testCase1() {
        new HomePagePO(driver()).load();
        log.info("Test case 1");
    }

    @Test
    public void testCase2() {
        new HomePagePO(driver()).load();
        log.info("Test case 2");
    }
}
