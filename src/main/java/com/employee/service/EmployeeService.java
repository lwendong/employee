package com.employee.service;

import com.employee.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployeeByCode(String Code);

    public Boolean addEmployee(Employee employee);

    public Boolean updateEmployeeById(Employee employee);

    public Integer queryCountByDeptCode(String code);

    public List<Employee> queryEmployeePage(int pageNo, int pageNum, String search);

    public Boolean updateEmployee(Employee employee);
}
