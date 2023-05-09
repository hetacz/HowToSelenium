package com.qualityminds.seleniumframework.utils;

import lombok.experimental.UtilityClass;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@UtilityClass
public class Upload {

    public String parseFilename(String filename) {
        return decodeQuery(getPath(filename));
    }

    private String decodeQuery(String query) {
        return URLDecoder.decode(query, StandardCharsets.UTF_8);
    }

    private String getPath(String filename) {
        return Objects.requireNonNull(Upload.class.getClassLoader().getResource(filename)).getPath();
    }
}
