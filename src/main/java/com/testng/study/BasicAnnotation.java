package com.testng.study;

import org.testng.annotations.*;

public class BasicAnnotation {


    @Test
    public void testCase1(){
        System.out.println("case1");
    }

    @Test
    public void testCase2(){
        System.out.println("case2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("运行在方法前！！！");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("运行在方法后！！！");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("运行在类之前！！！");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("运行在类之后！！！");
    }


    @BeforeGroups
    public void beforeGroup(){
        System.out.println("beforeGroup测试套件");
    }

    @AfterGroups
    public void afterGroup(){
        System.out.println("afterGroup测试套件");
    }

}
