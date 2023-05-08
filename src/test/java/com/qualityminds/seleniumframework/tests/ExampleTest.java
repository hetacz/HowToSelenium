package com.qualityminds.seleniumframework.tests;

import com.qualityminds.seleniumframework.base.BaseTest;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest() {
        driver().get("https://qualityminds.com");
    }
}
