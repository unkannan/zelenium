package com.gurukula.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

    private static Properties prop;

    /**
     * This function is to read properties file
     *
     * @return propertires
     */
    public static Properties getProperties() {
        try {
            InputStream input = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

}