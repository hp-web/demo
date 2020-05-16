package com.example.demo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test_01 {

    public static final Logger logger = Logger.getLogger(Test_01.class);

    @Test
    public void TestCase() throws IOException, InterruptedException {
        //使用remote driver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("78.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://192.168.1.6:4444/wd/hub").toURL(),
                capabilities
        );
        //System.setProperty("webdriver.chrome.driver",getClass().getResource("/chromedriver.exe").getPath());
        // WebDriver driver = new ChromeDriver();

        driver.get("http://www.baidu.com");
//        new WebDriverWait(driver, 300).until(driver -> ((JavascriptExecutor) driver)
//                .executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.id("kw")).sendKeys("豆瓣");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a[1]/em")).click();
        Thread.sleep(5000);

        JavascriptExecutor jexec = driver;

        long width = (long) jexec.executeScript("return document.body.scrollWidth");
        long height = (long) jexec.executeScript("return document.body.scrollHeight");
        //设置浏览窗口大小
        driver.manage().window().setSize(new Dimension((int) width, (int) height));
        Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver);
        BufferedImage image = screenshot.getImage();
        ImageIO.write(image, "PNG", new File("D:\\temp\\" + "AShot_BBC_Entire.png"));
        driver.quit();

    }

    public static void main(String[] args) {
        logger.info("log4j for info");
        logger.debug("log4j for debug");
        logger.error("log4j for error");
        logger.warn("log4j for warn");

    }
//
//    @BeforeClass
//    public static void UtilDriver() {
//
//        System.setProperty("webdriver.chrome.driver", Test_01.class.getResource("/chromedriver.exe").getPath());
//        WebDriver driver = new ChromeDriver();
//
//    }
//
//
//    @FindBy(xpath = "//*[@id=\\\"1\\\"]/h3/a[1]/em")
//    public static WebElement xxxButton;
//
//
//    public void caozuo() {
//
//        xxxButton.click();
//
//
//    }


//
//    @BeforeTest
//    public void getBaidu(){
//        UtilDriver().get("http://www.baidu.com");
//    }
//    @Test
//    public void searchValue() throws InterruptedException {
//        UtilDriver().findElement(By.id("kw")).sendKeys("豆瓣");
//        UtilDriver().findElement(By.id("su")).click();
//        Thread.sleep(5000);
//
//    }


//public void locoXy(String loc,int x,int y){
//    WebElement webElement = driver.findElement(By.xpath(loc));
//    Actions actions = new Actions(driver);
//    actions.moveToElement(webElement,x,y).click().perform();
//}


    @Test
    public void testLog4j() {


        logger.info("slf4j for info");
        logger.debug("slf4j for debug");
        logger.error("slf4j for error");
        logger.warn("slf4j for warn");

    }


    @Test
    public void testRandom() {

        // hashSet无序不重复
        HashSet<Integer> set = new HashSet<>();
        //在20区间内 生成10个不重复的随机数
        int c = 0;
        while (true) {
            if (set.size() < 10) {
                set.add(new Random().nextInt(100));//生成随机数
            } else if (set.size() == 10) {
                break;
            }
            c++;
        }
        for (Integer k : set) {
            System.out.println(k);
        }
        System.out.println(set.size()); //打印长度
        System.out.println(c);//打印循环次数
    }

    //1111

//    public static void BasetoPdffile(String pdfBase64Str, String filepath) {
//        BufferedInputStream bis = null;
//        FileOutputStream fos = null;
//        BufferedOutputStream bos = null;
//        try {
//            byte[] bytes = Base64.decode(pdfBase64Str);
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//            bis = new BufferedInputStream(byteArrayInputStream);
//            File file = new File(filepath);
//            File path = file.getParentFile();
//            if (!path.exists()) {
//                path.mkdirs();
//            }
//            fos = new FileOutputStream(file);
//            bos = new BufferedOutputStream(fos);
//
//            byte[] buffer = new byte[1024];
//            int length = bis.read(buffer);
//            while (length != -1) {
//                bos.write(buffer, 0, length);
//                length = bis.read(buffer);
//            }
//            bos.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bis.close();
//                bos.close();
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


//    public static void main(String[] args) {
//
//        String pdf_data = "####";
//        String fileName = "&&&&&";
//        BasetoPdffile(pdf_data, "D:\\新建文件夹\\PDF文件\\" + fileName);
//    }


    @Test
    public void valueOfTest() {

        System.out.println(new Date());
        Date date = new Date();
        String s = "YYYY-MM-DD HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(s);
        System.out.println(simpleDateFormat.format(date));

        List<String> list = new ArrayList<>();
        list.add("342");
        list.add("ewq");
        list.add("32");

        list.remove(1);
        System.out.println(list);
        for (String str : list) {
            System.out.println(str);
        }


    }

}
