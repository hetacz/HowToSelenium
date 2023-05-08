package com.qualityminds.seleniumframework.pages;

import com.qualityminds.seleniumframework.base.BasePage;
import com.qualityminds.seleniumframework.base.I18n;

public interface LocaleLoadable<T extends BasePage> {

    T load(I18n i18n);

    T waitForPageToLoad(I18n i18n);
}
