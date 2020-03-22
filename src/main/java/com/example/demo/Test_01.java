package com.example.demo;

import com.example.util.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test_01 {

    public static final Logger logger = Logger.getLogger(Test_01.class);
    Base base = new Base();

    public static void main(String[] args) {
        logger.info("log4j for info");
        logger.debug("log4j for debug");
        logger.error("log4j for error");
        logger.warn("log4j for warn");

    }
    @Test
    public void TestCase() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",getClass().getResource("/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
//        new WebDriverWait(driver, 300).until(driver -> ((JavascriptExecutor) driver)
//                .executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.id("kw")).sendKeys("豆瓣");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a[1]/em")).click();
        Thread.sleep(5000);

        JavascriptExecutor jexec = (JavascriptExecutor) driver;

        long width = (long) jexec.executeScript("return document.body.scrollWidth");
        long height = (long) jexec.executeScript("return document.body.scrollHeight");
        //设置浏览窗口大小
        driver.manage().window().setSize(new Dimension((int)width, (int)height));
        Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver);
        BufferedImage image = screenshot.getImage();
        ImageIO.write(image, "PNG", new File("D:\\temp\\" + "AShot_BBC_Entire.png"));
        driver.quit();
    }

    @Test
    public void testLog4j(){
        logger.info("slf4j for info");
        logger.debug("slf4j for debug");
        logger.error("slf4j for error");
        logger.warn("slf4j for warn");


    }


}
