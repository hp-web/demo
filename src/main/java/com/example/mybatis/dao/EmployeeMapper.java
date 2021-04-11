package com.example.mybatis.dao;

import com.example.mybatis.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    @MapKey("id")
    public Map<String,Employee> getEmpById(Map<String,List<String>> map);
}
