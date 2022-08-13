package com.singtel.automation.framework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static String propertiesFolder = "src/test/resources/properties/";

    private static FileReader getPropertiesFromFile(String filePath) throws FileNotFoundException {
        File propFile = new File(filePath);
        return new FileReader(propFile.getAbsolutePath());
    }

    public static String getTestBedProperties(String propertyName) {
        Properties prop = new Properties();
        try {
            prop.load(getPropertiesFromFile(propertiesFolder + "TestBed.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }

    public static String getPropertyValue(String type, String propertyName) {
        String environment;
        String lob;

        environment = System.getProperty("env");
        lob = System.getProperty("lob");
        if (environment == null || lob == null) {
            lob = getTestBedProperties("lob").toLowerCase();
            environment = getTestBedProperties("environment").toUpperCase();
            System.setProperty("lob", lob);
            System.setProperty("env", environment);
        }
        Properties prop = new Properties();
        try {
            prop.load(getPropertiesFromFile(propertiesFolder + type + "/" + lob + "/" + environment + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }

    public static String getEnvProperties(String propertyName) {

        return getPropertyValue("env", propertyName);
    }

    public static String getApiProperties(String propertyName) {

        return getPropertyValue("api", propertyName);
    }
}