package com.qualityminds.seleniumframework.tests;

import com.qualityminds.seleniumframework.base.BaseTest;
import com.qualityminds.seleniumframework.base.I18n;
import com.qualityminds.seleniumframework.utils.StringLoader;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @Test
    public void exampleTest() {
        driver().get("https://qualityminds.com");
        System.err.println(StringLoader.getInstance().strings(I18n.ENGLISH).toPrettyString());
    }
}
