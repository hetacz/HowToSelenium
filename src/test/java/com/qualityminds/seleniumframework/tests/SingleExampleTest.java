package com.qualityminds.seleniumframework.tests;

import com.qualityminds.seleniumframework.base.BaseTest;
import com.qualityminds.seleniumframework.page.HomePagePO;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class SingleExampleTest extends BaseTest {

    @Test
    public void aloneTest() {
        new HomePagePO(driver()).load();
        log.info("Alone test case");
    }
}
