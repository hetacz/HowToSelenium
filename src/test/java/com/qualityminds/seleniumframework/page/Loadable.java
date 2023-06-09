package com.qualityminds.seleniumframework.page;

import com.qualityminds.seleniumframework.base.BasePage;

interface Loadable<T extends BasePage> {

    T load();

    T waitForPageToLoad();
}
