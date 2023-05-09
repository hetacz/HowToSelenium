package com.qualityminds.seleniumframework.page;

import com.qualityminds.seleniumframework.base.BasePage;
import com.qualityminds.seleniumframework.base.I18n;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoTestPO extends BasePage implements LocaleLoadable<AutoTestPO>, Localizable {

    private final By h1 = By.cssSelector("h1 > span");
    private final By contactBtn = By.cssSelector("a.et_pb_button");

    public AutoTestPO(WebDriver driver) {
        super(driver);
    }

    @Override
    public AutoTestPO load(I18n i18n) {
        load(getString(i18n, AUTOMATION_URL));
        waitForPageToLoad(i18n);
        return this;
    }

    @Override
    public AutoTestPO waitForPageToLoad(I18n i18n) {
        waitForPageTitle(getString(i18n, AUTOMATION_TITLE));
        waitForPageUrl(getString(i18n, AUTOMATION_URL));
        verifyH1Text(i18n);
        logPageLoaded();
        return this;
    }

    public AutoTestPO verifyContactUsBtn(I18n i18n) {
        scrollDown();
        Assertions.assertThat(getVisibleElement(contactBtn).getAttribute("href")).contains(getString(i18n, EMAIL));
        return this;
    }

    private void verifyH1Text(I18n i18n) {
        Assertions.assertThat(getText(h1)).isEqualTo(getString(i18n, H1_TEXT));
    }
}
