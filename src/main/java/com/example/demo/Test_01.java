package com.example.demo;

import com.example.util.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_01 {
    Base base = new Base();
    @Test
    public void TestCase() throws IOException {
        System.setProperty("webdriver.chrome.driver",getClass().getResource("/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        String s = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/a[1]")).getText();
        System.out.println(s);
        base.getText("gettxt/1.txt",s);
    }
}
