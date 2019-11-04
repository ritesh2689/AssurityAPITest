package com.assurity.base;

import com.assurity.utils.PropertyUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * Contains methods to be used by various test classes.Will work as base class for others.
 *
 * @author Ritesh Vashisth
 */
public class TestBase {

    private static Logger log = Logger.getLogger(TestBase.class.getName());
    private PropertyUtils propertyUtils = new PropertyUtils();
    public static HashMap<String, String> testData = new HashMap<String, String>();

    /**
     * Initial method to load property files.This method will execute before test suite starts
     */
    @BeforeSuite(description = "Initial method to load property files.This method will execute before test suite starts")
    public void loadProperties() {
        try {
            log.debug("****** Before Suite Called ******");
            loadTestData();
        } catch (Exception e) {
            log.debug("Exception occurred - " + e.getMessage());
        }
    }

    /**
     * Method to read property files and store data in testData hashmp
     * which can be used across various test classes
     */
    private void loadTestData() {
        Properties props = propertyUtils.getAllPropertySet();
        Enumeration<?> paramNames = props.propertyNames();
        while (paramNames.hasMoreElements()) {
            String idParam = (String) paramNames.nextElement();
            testData.put(idParam, (String) props.get(idParam));
        }
    }

    /**
     * Method that runs after suite completes.Tear down calls can be included here.
     */
    @AfterSuite(description = "Method that runs after suite completes")
    public void tearDown() {
        log.debug("******* Test Suite Finished ******");
    }
}
