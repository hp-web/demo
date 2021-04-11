package com.utils;

import org.testng.annotations.BeforeTest;

import java.util.Locale;
import java.util.ResourceBundle;

public class ReadProperties {
    public static String getBundle(String key){
        ResourceBundle application = ResourceBundle.getBundle("application", Locale.CHINA);
        return application.getString(key);
    }

}
