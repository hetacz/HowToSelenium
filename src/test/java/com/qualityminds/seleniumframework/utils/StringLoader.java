package com.qualityminds.seleniumframework.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.qualityminds.seleniumframework.base.AutomationException;
import com.qualityminds.seleniumframework.base.I18n;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public final class StringLoader {

    private static final String FILE_NAME = "strings.json";
    private final JsonNode strings;

    private StringLoader() throws IOException {
        this.strings = Parser.toJsonNode(FILE_NAME);
    }

    public static StringLoader getInstance() {
        return Holder.INSTANCE;
    }

    public JsonNode strings(I18n i18n) {
        return strings.get(i18n.name().toLowerCase());
    }


    private enum Holder {
        ;

        static final StringLoader INSTANCE; // non private for optimization
        private static final String ERR_MSG = "Error while reading json files.";

        static {
            try {
                INSTANCE = new StringLoader();
            } catch (IOException e) {
                log.error(ERR_MSG, e);
                throw new AutomationException(ERR_MSG, e);
            }
        }
    }
}
