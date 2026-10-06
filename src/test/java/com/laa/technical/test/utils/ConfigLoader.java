package com.laa.technical.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigLoader {

    private static final Properties properties = new Properties();

    public static String getProperty(String fileName, String key) {

        String resourcePath = "propertyFiles/" + fileName;

        try (InputStream inputStream = ConfigLoader.class
                .getClassLoader()
                .getResourceAsStream(resourcePath)) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "Property file not found: " + resourcePath);
            }

            properties.clear();
            properties.load(inputStream);

            String value = properties.getProperty(key);

            if (value == null) {
                throw new RuntimeException(
                        "Property key not found: " + key);
            }

            return value;

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load property file: " + resourcePath, e);
        }
    }
}
