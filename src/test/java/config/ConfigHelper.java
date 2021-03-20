package config;

public class ConfigHelper {

    public static String getBrowserName(){
        return "Chrome";
    }

    public static String getBrowserVersion(){
        return "48.0";
    }

    public static String getWebDriver(){
        return "https://localhost:4444";
    }

    public static String getBaseURL(){
        return "https://www.crystals.ru/";
    }

    public static String getWebVideoStorage() {
        return System.getProperty("video.storage");
    }




}
