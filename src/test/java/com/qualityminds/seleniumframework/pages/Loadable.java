package com.qualityminds.seleniumframework.pages;

import com.qualityminds.seleniumframework.base.BasePage;

public interface Loadable<T extends BasePage> {

    T load();

    T waitForPageToLoad();
}
