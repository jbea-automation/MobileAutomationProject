package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility {

    public static String getPropertyFrom(String property, String location) throws Throwable {
        Properties prop = new Properties();
        prop.load(new FileInputStream(System.getProperty("user.dir") +
                "/src/test/resources/properties/" + location + "/ApplicationProperties.properties"));
        return prop.getProperty(property);
    }

}
