package com.employee.service;

import com.employee.pojo.Dept;

import java.util.List;

public interface DeptService {

    public Boolean addDept(Dept dept);

    public List<Dept> queryDeptPage(int pageNo,int pageNum,String search);

    public Dept queryDeptByCode(String code);
}
