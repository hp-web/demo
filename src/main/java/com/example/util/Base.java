package com.example.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Base {


    public static Properties prop;
    public static WebDriver driver;





    public Base(){
        prop = new Properties();


    }




    /*
    * 获取页面文本
    * */
    public void getText(String path,String text) throws IOException {
        PrintWriter pw = new PrintWriter( new FileWriter( path ) );
        pw.print(text);
        pw.close();
    }
    
    
        @Test
    public void writeTxtFile() throws IOException {
        //创建StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0;i<100;i++){
            stringBuffer.append("Hello Java world, I am the exception.\n");

        }
        //System.out.println(stringBuffer.toString());
        //写入txt
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try{
            fos = new FileOutputStream(new File("D:/test.txt"));
            osw = new OutputStreamWriter(fos,"UTF-8");
            osw.write(stringBuffer.toString());
            osw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fos!=null){
                fos.close();
            }if (osw!=null){
                osw.close();
            }
        }
        //读取txt
        FileInputStream fis = null;
        InputStreamReader isr= null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(new File("D:/test.txt"));
            isr = new InputStreamReader(fis,"UTF-8");
            br = new BufferedReader(isr);
            String str = "";
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fis!=null){
                fis.close();
            }if (isr!=null){
                isr.close();
            }if (br!=null){
                br.close();
            }
        }


        
        
    }

}
