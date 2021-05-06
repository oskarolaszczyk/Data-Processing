package tech.problem_workshop.data_processing.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesLoader {

    private static final PropertiesLoader INSTANCE = new PropertiesLoader();

    private PropertiesLoader() {
        loadProperties();
    }

    private static void loadProperties() {
        Properties prop = null;
        try {
            prop = new Properties();
            InputStream inputStream  = PropertiesLoader.class.getClassLoader()
                    .getResourceAsStream("application.properties");
            if (inputStream != null) {
                prop.load(inputStream);
            }
        } catch (IOException e) {
            // TODO: 18.04.2021
        }
//        confirmationJwtSecret = prop.getProperty("confirmation.jwt.secret");
    }
}
