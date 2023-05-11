package com.qualityminds.seleniumframework.page;

import com.qualityminds.seleniumframework.base.BasePage;
import com.qualityminds.seleniumframework.base.I18n;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class HomePagePO extends BasePage implements LocaleLoadable<HomePagePO>, Loadable<HomePagePO>, Localizable {

    @Getter
    private final TopBarPO topBarPO;

    public HomePagePO(WebDriver driver) {
        super(driver);
        this.topBarPO = new TopBarPO(driver);
    }

    @Override
    public HomePagePO load() {
        home();
        waitForPageToLoad();
        return this;
    }

    @Override
    public HomePagePO waitForPageToLoad() {
        waitForPageToLoad(I18n.ENGLISH);
        return this;
    }

    @Override
    public HomePagePO load(I18n i18n) {
        load(i18n.getUrl());
        waitForPageToLoad(i18n);
        return this;
    }

    @Override
    public HomePagePO waitForPageToLoad(I18n i18n) {
        waitForPageTitle(getString(i18n, HOME_TITLE));
        waitForPageUrl(getString(i18n, HOME_URL));
        logPageLoaded();
        return this;
    }

    public HomePagePO closeCookies() {
        acceptCookies();
        return this;
    }
}
