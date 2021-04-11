/*
package com.example.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.mybatis.Employee;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadExcel {
    public List<Employee> read(String fileName) throws EncryptedDocumentException, IOException {
        if (fileName == null) return null;

        File xlsFile = new File(fileName);
        if (!xlsFile.exists()) return null;

        // 工作表
        Workbook workbook = WorkbookFactory.create(xlsFile);
        // 表个数
        int numberOfSheets = workbook.getNumberOfSheets();
//      System.out.println(numberOfSheets);
        if (numberOfSheets <= 0) return null;

        List<Employee> list = new ArrayList<>();
        //我们的需求只需要处理一个表，因此不需要遍历
        Sheet sheet = workbook.getSheetAt(0);
        // 行数
        int rowNumbers = sheet.getLastRowNum() + 1;
//      System.out.println(rowNumbers);
        Employee id;
        // 读数据，第二行开始读取

        // Excel第一行。
        Row temp = sheet.getRow(0);
//        if (temp == null) {
//            continue;
//        }
        int cells = temp.getPhysicalNumberOfCells();
        for (int row = 1; row < rowNumbers; row++) {
            Row r = sheet.getRow(row);
//          System.out.println(r.getPhysicalNumberOfCells());
            //我们只需要前两列
//            if (r.getPhysicalNumberOfCells() >= 4) {
//                id = new Employee(Integer.parseInt(r.getCell(0).toString()),r.getCell(1).toString(),
//                        r.getCell(2).toString(),r.getCell(3).toString());
//                list.add(id);
//            }
            for (int col = 0; col < cells; col++) {
                System.out.print(r.getCell(col).toString()+" ");
            }

            // 换行。
            System.out.println();
        }
        return list;
    }

    @Test
    public void testReadExcel() throws IOException {

        read("excel/test.xlsl");

        System.out.println(read("excel/test.xlsl"));


    }

}
*/
