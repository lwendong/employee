package com.employee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.enums.CRUDEnum;
import com.employee.mapper.DeptMapper;
import com.employee.pojo.Dept;
import com.employee.pojo.Employee;
import com.employee.service.DeptService;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Boolean addDept(Dept dept) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mana_id",dept.getManaId());
        Dept dept1 = deptMapper.selectOne(queryWrapper);
        if(!ObjectUtils.isEmpty(dept1)){
            return false;
        }
        boolean b = deptMapper.insert(dept) > CRUDEnum.NULL_COUNT.getValue();
        if(b){
            Employee employeeByCode = employeeService.getEmployeeByCode(dept.getManaId());
            employeeByCode.setDeptCode(dept.getCode());
            employeeService.updateEmployeeById(employeeByCode);
        }
        return  b;
    }

    @Override
    public List<Dept> queryDeptPage(int pageNo,int pageNum,String search) {
        Page<Dept> page = new Page<>(pageNo,pageNum);
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(search), "name", search);
        Page<Dept> deptPage = deptMapper.selectPage(page, queryWrapper);
        List<Dept> depts = deptPage.getRecords();
        depts.forEach(dept -> {
            dept.setCount(employeeService.queryCountByDeptCode(dept.getCode()));
            dept.setManaName(employeeService.getEmployeeByCode(dept.getManaId()).getName());
        });
        return depts;

    }

    @Override
    public Dept queryDeptByCode(String code) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",code);
        return deptMapper.selectOne(queryWrapper);
    }
}
