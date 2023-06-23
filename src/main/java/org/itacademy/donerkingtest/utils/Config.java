package org.itacademy.donerkingtest.utils;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

@Log4j2
public class Config {

    private static String chromeDriver;
    private static String homePage;
    private static String dataFileMenu;
    private static String dataFileAddressbook;

    public static void getProperties() {
        log.info("CONFIG GET PROPERTIES");
        Properties properties = new Properties();
        URL resource = Create.class.getClassLoader().getResource("config.properties");
        File file = new File(Objects.requireNonNull(resource).getFile());
        try {
            FileInputStream in = new FileInputStream(file);
            properties.load(in);
            in.close();
            chromeDriver = properties.getProperty("chromeDriver");
            homePage = properties.getProperty("homePage");
            dataFileMenu = properties.getProperty("dataFileMenu");
            dataFileAddressbook = properties.getProperty("dataFileAddressbook");
            log.info("chromeDriver: " + chromeDriver);
            log.info("homePage: " + homePage);
            log.info("dataFileMenu: " + dataFileMenu);
            log.info("dataFileAddressbook: " + dataFileAddressbook);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getChromeDriver() {
        return chromeDriver;
    }

    public static String getHomePage() {
        return homePage;
    }

    public static String getDataFileMenu() {
        return dataFileMenu;
    }

    public static String getDataFileAddressbook() {
        return dataFileAddressbook;
    }
}
