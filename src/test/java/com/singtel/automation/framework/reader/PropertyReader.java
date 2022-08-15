package com.singtel.automation.framework.reader;

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
}