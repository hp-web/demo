package com.example.mybatis.dao;

import com.example.mybatis.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    public List<Employee> getEmpById(Map<String,List<String>> map);
}
