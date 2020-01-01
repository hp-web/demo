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
            Map<String,Employee> resultMap = new HashMap<>();
            for(List<String> key : excelResult.keySet()){
                //获取所有的id
                ids = key;
                //获取结果
                resultMap = excelResult.get(ids);
            }
            Map<String,List<String>> param = new HashMap<>();
            param.put("ids",ids);
            List<Employee> employee = mapper.getEmpById(param);
            System.out.println(mapper.getClass());
            System.out.println(employee);
        }finally {
            openSession.close();
        }

    }

}
