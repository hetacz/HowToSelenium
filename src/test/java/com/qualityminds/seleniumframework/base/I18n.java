package com.qualityminds.seleniumframework.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum I18n {

    ENGLISH("en", "/"),
    GERMAN("de", "/de"),
    POLISH("pl", "/pl");

    private final String abbr;
    private final String url;
}
