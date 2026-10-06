package com.laa.technical.test.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class PayloadUtils {

    private static final String BASE_PATH = "src/test/resources/request_bodies/";

    public static String getRequestBody(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(BASE_PATH + fileName)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load request body file: " + fileName, e);
        }
    }

    public static String getRequestBody(String fileName, Map<String, ?> replacements) {
        String body = getRequestBody(fileName);
        for (Map.Entry<String, ?> entry : replacements.entrySet()) {
            body = body.replace("{{" + entry.getKey() + "}}", String.valueOf(entry.getValue()));
        }
        return body;
    }
}
