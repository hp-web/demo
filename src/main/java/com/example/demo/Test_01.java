package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_01 {
    @Test
    public void TestCase(){
        System.setProperty("webdriver.chrome.driver",getClass().getResource("/chromedriver").getPath());
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
    }

}
