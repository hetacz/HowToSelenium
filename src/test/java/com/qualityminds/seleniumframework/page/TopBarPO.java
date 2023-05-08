package com.qualityminds.seleniumframework.page;

import com.qualityminds.seleniumframework.base.AutomationException;
import com.qualityminds.seleniumframework.base.BasePage;
import com.qualityminds.seleniumframework.base.I18n;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopBarPO extends BasePage {


    private static final String UL_LI = "ul#top-menu > li";
    private static final String UL_LI_LAST = "ul#top-menu > li:last-child";
    private static final String UL_LI_A = " > ul.sub-menu > li > a[href='https://qualityminds.com%s']";
    private final By portfolioDrop = By.cssSelector(UL_LI);
    private final By portfolioSubmenu = By.cssSelector(UL_LI + " > ul.sub-menu");
    private final By atMenu = By.cssSelector(UL_LI + " > ul.sub-menu > li > ul.sub-menu > li:nth-child(3)");
    private final By languageDrop = By.cssSelector(UL_LI_LAST);
    private final By languageSubmenu = By.cssSelector(UL_LI_LAST + " > ul.sub-menu");
    private final By languageDropCurrentIcon = By.cssSelector(UL_LI_LAST + " > a > img");
    private final By germanDrop = By.cssSelector(UL_LI + UL_LI_A.formatted("de"));
    private final By polishDrop = By.cssSelector(UL_LI + UL_LI_A.formatted("pl"));
    private final By englishDrop = By.cssSelector(UL_LI + UL_LI_A.formatted(""));

    protected TopBarPO(WebDriver driver) {
        super(driver);
    }

    public TopBarPO hoverOverLanguageDrop() {
        hoverOver(languageDrop);
        getVisibleElement(languageSubmenu);
        return this;
    }

    public TopBarPO hoverOverPortfolioMenu() {
        hoverOver(portfolioDrop);
        getVisibleElement(portfolioSubmenu);
        return this;
    }

    public AutoTestPO clickAtAutomationTestsMenu() {
        throwIfNotVisible(atMenu);
        click(atMenu);
        return new AutoTestPO(driver);
    }

    public TopBarPO clickGermanDrop() {
        throwIfNotVisible(germanDrop);
        click(germanDrop);
        return this;
    }

    public TopBarPO clickPolishDrop() {
        throwIfNotVisible(polishDrop);
        click(polishDrop);
        return this;
    }

    public TopBarPO clickEnglishDrop() {
        throwIfNotVisible(englishDrop);
        click(englishDrop);
        return this;
    }

    public TopBarPO verifyCurrentLanguageIcon(I18n i18n) {
        Assertions.assertThat(getVisibleElement(languageDropCurrentIcon).getAttribute("src")).contains(getImgSrc(i18n));
        return this;
    }

    private String getImgSrc(I18n i18n) {
        return switch (i18n) {
            case ENGLISH -> "en.png";
            case GERMAN -> "de.png";
            case POLISH -> "pl.png";
        };
    }

    private void throwIfNotVisible(By locator) {
        if (!driver.findElement(locator).isDisplayed()) {
            throw new AutomationException("Element is not visible");
        }
    }
}
