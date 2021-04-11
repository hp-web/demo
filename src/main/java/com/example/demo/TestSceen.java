package com.example.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class TestSceen {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", TestSceen.class.getResource("/chromedriver.exe").getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        WebDriver driver =  new ChromeDriver(options);
        driver.get("https://open.douyin.com/platform");
        Thread.sleep(5000);
        Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        ImageIO.write(myScreenshot.getImage(), "PNG", new File("D:\\temp\\" + "AShot_BBC_Entire.png"));
        driver.quit();
    }
}