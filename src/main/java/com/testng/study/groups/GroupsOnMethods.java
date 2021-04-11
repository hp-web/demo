package com.testng.study.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethods {

    @Test(groups = "client")
    public void groupCase1(){
        System.out.println("客户端测试case1");
    }

    @AfterGroups("client")
    public void afterGroups(){
        System.out.println("运行在组后");
    }

    @BeforeGroups("client")
    public void beforeGroups(){
        System.out.println("运行在组前");
    }

}
