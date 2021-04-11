package com.testng.study.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforeSuit测试套件");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("afterSuit测试套件");
    }

    @BeforeTest
    public void beforeMethod(){
        System.out.println("运行在case前！！！");
    }

    @AfterTest
    public void afterMethod(){
        System.out.println("运行在case后！！！");
    }





}
