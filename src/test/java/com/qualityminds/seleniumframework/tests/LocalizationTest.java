package com.qualityminds.seleniumframework.tests;

import com.qualityminds.seleniumframework.base.BaseTest;
import com.qualityminds.seleniumframework.base.I18n;
import com.qualityminds.seleniumframework.page.HomePagePO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LocalizationTest extends BaseTest {

    @DataProvider(parallel = true)
    public I18n[] getI18n() {
        return I18n.values();
    }

    @Test(dataProvider = "getI18n")
    public void verifyTestAutomationPageTranslation(I18n i18n) {
        new HomePagePO(driver())
                .load()
                .closeCookies()
                .getTopBarPO()
                .verifyCurrentLanguageIcon(I18n.ENGLISH)
                .hoverOverLanguageDrop()
                .changeDefaultLanguage(i18n)
                .verifyCurrentLanguageIcon(i18n)
                .hoverOverPortfolioMenu()
                .clickAtAutomationTestsSubMenu()
                .waitForPageToLoad(i18n)
                .verifyContactUsBtn(i18n);
    }
}
