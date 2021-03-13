package helpers;

import com.codeborne.selenide.Configuration;

public class DriverHelper {
    public static void configureDriver(){
        Configuration.baseUrl = "https://www.crystals.ru/";
    }
}
