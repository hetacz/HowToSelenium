package com.qualityminds.seleniumframework.page;

import com.qualityminds.seleniumframework.base.AutomationException;
import com.qualityminds.seleniumframework.base.BasePage;
import com.qualityminds.seleniumframework.base.I18n;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class TopBarPO extends BasePage {


    private static final String UL_LI = "ul#top-menu > li";
    private static final String UL_LI_LAST = "ul#top-menu > li:last-child";
    private static final String UL_LI_A = " > ul.sub-menu > li > a[href='https://qualityminds.com%s']";
    private final By portfolioDrop = By.cssSelector(UL_LI);
    private final By portfolioSubmenu = By.cssSelector(UL_LI + " > ul.sub-menu");
    private final By atSubMenu = By.cssSelector(UL_LI + " > ul.sub-menu > li > ul.sub-menu > li:nth-child(3)");
    private final By languageDrop = By.cssSelector(UL_LI_LAST);
    private final By languageSubmenu = By.cssSelector(UL_LI_LAST + " > ul.sub-menu");
    private final By languageDropCurrentIcon = By.cssSelector(UL_LI_LAST + " > a > img");
    private final By germanDrop = By.cssSelector(UL_LI + UL_LI_A.formatted("/de"));
    private final By polishDrop = By.cssSelector(UL_LI + UL_LI_A.formatted("/pl"));
    private final By englishDrop = By.cssSelector(UL_LI + UL_LI_A.formatted(""));

    protected TopBarPO(WebDriver driver) {
        super(driver);
    }

    public AutoTestPO clickAtAutomationTestsSubMenu() {
        throwIfNotVisible(atSubMenu);
        click(atSubMenu);
        return new AutoTestPO(driver);
    }

    public TopBarPO changeDefaultLanguage(I18n i18n) {
        if (i18n == I18n.ENGLISH) {
            log.debug("Default language is English");
            return this;
        }
        clickLanguageDrop(i18n);
        return this;
    }

    public TopBarPO verifyCurrentLanguageIcon(I18n i18n) {
        Assertions.assertThat(isCurrentLanguageCorrect(i18n)).isTrue();
        return this;
    }

    private void clickLanguageDrop(I18n i18n) {
        hoverOverLanguageDrop();
        throwIfNotVisible(selectDropdown(i18n));
        click(selectDropdown(i18n));
    }

    private void hoverOverLanguageDrop() {
        hoverOver(languageDrop);
        getVisibleElement(languageSubmenu);
    }

    private void hoverOverPortfolioMenu() {
        hoverOver(portfolioDrop);
        getVisibleElement(portfolioSubmenu);
    }

    private boolean isCurrentLanguageCorrect(I18n i18n) {
        return getVisibleElement(languageDropCurrentIcon).getAttribute("src").contains(i18n.getAbbr() + ".png");
    }

    private By selectDropdown(I18n i18n) {
        return switch (i18n) {
            case ENGLISH -> englishDrop;
            case GERMAN -> germanDrop;
            case POLISH -> polishDrop;
        };
    }

    private void throwIfNotVisible(By locator) {
        if (!driver.findElement(locator).isDisplayed()) {
            throw new AutomationException("Element is not visible");
        }
    }
}
