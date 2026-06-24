package net.morthen.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleConstants {
    public static final String MOD_ID = "example";
    public static final String MOD_NAME = "Example";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void initCommon() {
        LOGGER.info("Common initialized");
    }

    public static void initClient() {
        LOGGER.info("Client initialized");
    }
}
