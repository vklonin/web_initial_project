package helpers;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;

public class DriverHelper {
    public static void configureDriver(){
        Configuration.baseUrl = ConfigHelper.getBaseURL();
    }
}
