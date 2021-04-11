package com.example.UtilsDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

public class GetDriver {

    private  static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }




    public GetDriver(){
        System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

}
