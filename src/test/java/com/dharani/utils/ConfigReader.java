package com.dharani.utils;

/** Central place for test settings. Override with -Dbrowser=edge or -Dheadless=true. */
public final class ConfigReader {
    private ConfigReader() {}

    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String VALID_USER = "standard_user";
    public static final String LOCKED_USER = "locked_out_user";
    public static final String PASSWORD = "secret_sauce"; // public demo password shown on saucedemo.com

    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", "false"));
    }
}
