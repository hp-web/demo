package com.example.mybatis;

import com.example.mybatis.dao.EmployeeMapper;
import com.example.util.ReadExcel2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
/*    @Test
    public void test() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Employee employee = openSession.selectOne("mapper.CountryMapper.selectEmp",1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }*/
//    @Test(dependsOnMethods = "test")
//    public void test1(){
//        Employee employee = new Employee();
//        //employee.getLast_name();
//        System.out.println(employee.getEmail());
//    }

    /*接口式编程
    * */


    @Test
    public void test01() throws IOException {
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
        //获取接口的实现类对象
            //会为接口自动创建一个代理对象，代理对象会去执行增删改查
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            ReadExcel2 readExcel2 = new ReadExcel2();
            List<String> ids = new ArrayList<>();
            //获取到需要查询的id集合和所有结果
            Map<List<String>, Map<String,Employee>> excelResult = readExcel2.getExcelResult();
            Map<String,Employee> excelResultMap = new HashMap<>();
            for(List<String> key : excelResult.keySet()){
                //获取所有的id
                ids = key;
                //获取结果
                excelResultMap = excelResult.get(ids);
            }
            Map<String,List<String>> param = new HashMap<>();
            param.put("ids",ids);
            Map<String,Employee> dbResultMap = mapper.getEmpById(param);
            List<List<String>> outExcelResult =  conpareResult(excelResultMap,dbResultMap);

            String outPath = "src/main/resources/excel/outputTest.xlsx";
            readExcel2.writeExcel(outExcelResult,outPath);

        }finally {
            openSession.close();
        }

    }




    private List<List<String>>  conpareResult(Map<String, Employee> excelResultMap, Map<String, Employee> dbResultMap) {
        List<List<String>> outResultExcel = new ArrayList<>();
        for(String id :excelResultMap.keySet()){
            Employee excelEmployee = excelResultMap.get(id);
            Employee dbEmployee = dbResultMap.get(id);
            List<String> col = new ArrayList<>();
            if(excelEmployee.equals(dbEmployee)){
                System.out.println("id为:"+id+"与数据库结果比对相同,"+"结果为:"+excelEmployee);
                col.add(excelEmployee.getCaseNumber());
                col.add(id);
                col.add("结果相同");
                col.add("1");
            }else{
                if(dbEmployee == null){
                    System.out.println("id为:"+id+"数据库无与此对应的数据" );
                    col.add(excelEmployee.getCaseNumber());
                    col.add(id);
                    col.add("数据库不存在此记录");
                }
                else{
                    System.out.println("id为:"+id+"与数据库结果比对不同,"+"excel结果为:"+excelEmployee+"db结果为:" +dbEmployee);
                    col.add(excelEmployee.getCaseNumber());
                    col.add(id);
                    col.add("数据库存在结果，对比不同");
                }
            }
            outResultExcel.add(col);
        }
        return outResultExcel;
    }




}
