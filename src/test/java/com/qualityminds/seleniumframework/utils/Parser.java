package com.qualityminds.seleniumframework.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@UtilityClass
public class Parser {

    private final ObjectMapper MAPPER = new ObjectMapper();

    public JsonNode toJsonNode(String fileName) throws IOException {
        return MAPPER.readTree(reader(fileName));
    }

    private InputStreamReader reader(String fileName) {
        return new InputStreamReader(Objects.requireNonNull(Upload.class
                .getClassLoader()
                .getResourceAsStream(fileName)), StandardCharsets.UTF_8);
    }
}
