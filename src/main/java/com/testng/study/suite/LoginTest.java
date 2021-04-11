package com.testng.study.suite;

import org.testng.annotations.Test;

public class LoginTest {




//    @Test
//    public void testDataProvider(String name,int age){
//        System.out.println(name + age);
//    }

    @Test
    public void login(){
        System.out.println("登录成功");
    }

    @Test(enabled = true)
    public void loginErrorTest(){
        System.out.println("登陆异常测试");
    }
}
