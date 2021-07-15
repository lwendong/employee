package com.employee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.enums.CRUDEnum;
import com.employee.mapper.EmployeeMapper;
import com.employee.pojo.Dept;
import com.employee.pojo.Employee;
import com.employee.service.DeptService;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DeptService deptService;

    @Override
    public Employee getEmployeeByCode(String code) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",code);
        Employee employee = employeeMapper.selectOne(queryWrapper);
        if(employee.getDeptCode() != null){
            Dept dept = deptService.queryDeptByCode(employee.getDeptCode());
            if(!ObjectUtils.isEmpty(dept)){
                employee.setDeptName(dept.getName());
                queryWrapper.clear();
                queryWrapper.eq("code",dept.getManaId());
                employee.setManagerName(employeeMapper.selectOne(queryWrapper).getName());
            }
        }
        return employee;
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        return employeeMapper.insert(employee) > CRUDEnum.NULL_COUNT.getValue();
    }

    @Override
    public Boolean updateEmployeeById(Employee employee) {
        return employeeMapper.updateById(employee) > CRUDEnum.NULL_COUNT.getValue();
    }

    @Override
    public Integer queryCountByDeptCode(String code) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dept_code",code);
        return employeeMapper.selectCount(queryWrapper);
    }

    @Override
    public List<Employee> queryEmployeePage(int pageNo, int pageNum, String search) {
        Page<Employee> page = new Page<>(pageNo,pageNum);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(search), "name", search);
        Page<Employee> employeePage = employeeMapper.selectPage(page, queryWrapper);
        return employeePage.getRecords();
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",employee.getCode());
        return employeeMapper.update(employee,queryWrapper) > CRUDEnum.NULL_COUNT.getValue();
    }
}
