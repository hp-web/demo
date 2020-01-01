package com.example.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Base {

    /*
    * 获取页面文本
    * */
    public void getText(String path,String text) throws IOException {
        PrintWriter pw = new PrintWriter( new FileWriter( path ) );
        pw.print(text);
        pw.close();
    }

}
