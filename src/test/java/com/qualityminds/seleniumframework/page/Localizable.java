package com.qualityminds.seleniumframework.page;

import com.qualityminds.seleniumframework.base.I18n;
import com.qualityminds.seleniumframework.utils.StringLoader;

interface Localizable {

    String HOME_URL = "home_url";
    String HOME_TITLE = "home_title";
    String AUTOMATION_URL = "automation_url";
    String AUTOMATION_TITLE = "automation_title";
    String H1_TEXT = "h1_text";
    String EMAIL = "email";

    default String getString(I18n i18n, String key) {
        return StringLoader.getInstance().strings(i18n).get(key).asText();
    }
}
