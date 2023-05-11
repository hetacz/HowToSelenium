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
    private static final String UL_LI_A = " > ul.sub-menu > li > a[href='https://qualityminds.com%s']";
    private static final String UL_LI_LAST = "//ul[@id='top-menu']/li[(contains(@class, 'menu-item'))][last()]";
    private final By portfolioDrop = By.cssSelector(UL_LI);
    private final By portfolioSubmenu = By.cssSelector(UL_LI + " > ul.sub-menu");
    private final By atSubMenu = By.cssSelector(UL_LI + " > ul.sub-menu > li > ul.sub-menu > li:nth-child(3)");
    private final By languageDrop = By.xpath(UL_LI_LAST);
    private final By languageSubmenu = By.xpath(UL_LI_LAST + "/a/following-sibling::ul");
    private final By languageDropCurrentIcon = By.xpath(UL_LI_LAST + "/a/img");

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

    public AutoTestPO clickAtAutomationTestsSubMenu() {
        throwIfNotVisible(atSubMenu);
        click(atSubMenu);
        return new AutoTestPO(driver);
    }

    public TopBarPO changeDefaultLanguage(I18n i18n) {
        if (i18n == I18n.ENGLISH) {
            log.debug("The default language is English.");
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
        throwIfNotVisible(selectDropdown(i18n));
        click(selectDropdown(i18n));
    }

    private boolean isCurrentLanguageCorrect(I18n i18n) {
        return getVisibleElement(languageDropCurrentIcon).getAttribute("src").contains(i18n.getAbbr() + ".png");
    }

    private By selectDropdown(I18n i18n) {
        return By.cssSelector(UL_LI + UL_LI_A.formatted(i18n.getHref()));
    }

    private void throwIfNotVisible(By locator) {
        if (!driver.findElement(locator).isDisplayed()) {
            throw new AutomationException("Element is not visible");
        }
    }
}
