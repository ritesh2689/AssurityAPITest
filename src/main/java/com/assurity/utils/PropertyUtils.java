package com.assurity.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Contains methods to read property files.
 *
 * @author Ritesh Vashisth
 */
public class PropertyUtils {
    private Properties properties;
    private static Logger log = Logger.getLogger(PropertyUtils.class.getName());

    public PropertyUtils() {
        properties = new Properties();
        try {
            properties.load(new FileReader(new File("src/main/resources/env.properties")));
            properties.load(new FileReader(new File("src/main/resources/apiEndPoints.properties")));
        } catch (IOException e) {
            log.error("Exception Occured while loading property file");
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public Properties getAllPropertySet() {
        return properties;
    }
}
