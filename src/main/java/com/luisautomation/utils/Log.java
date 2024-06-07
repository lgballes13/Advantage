package com.luisautomation.utils;

import java.util.logging.Logger;

public class Log {

    private Log() {
        throw new IllegalAccessError("Utility class");
    }
    private static final Logger LOGGER = Logger.getGlobal();
    private static final String ANSI_RESET = "\u001B[0m" ;
    private static final String ANSI_PURPLE = "\u001B[35m" ;
    private static final String ANSI_BLUE = "\u001B[34m" ;


    public static void printWarning(String msg) {
        LOGGER.warning(ANSI_PURPLE + msg + ANSI_RESET);
    }

    public static void printInfo(String msg) {
        LOGGER.info(ANSI_BLUE + msg + ANSI_RESET);
    }

    public static void printError(String msg) {
        LOGGER.severe(ANSI_PURPLE + msg + ANSI_RESET);
    }
}
