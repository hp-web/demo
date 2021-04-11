package com.testng.study.multiThreads;

import org.testng.annotations.Test;

public class ThreadTest {


    @Test
    public void case1(){
        System.out.printf("case 1:Thread ID : %s%n",Thread.currentThread().getId());
    }


    @Test
    public void case2(){
        System.out.printf("case 2:Thread ID : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void case3(){
        System.out.printf("case 3:Thread ID : %s%n",Thread.currentThread().getId());
    }

}
