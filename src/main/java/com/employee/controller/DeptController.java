package com.employee.controller;

import com.employee.pojo.Dept;
import com.employee.pub.Response;
import com.employee.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/add")
    public Response<List<Dept>> add(@RequestBody Dept dept){
        Boolean aBoolean = deptService.addDept(dept);
        if(aBoolean){
            return Response.SUCCESS(deptService.queryDeptPage(1,9,null),"添加并查询数据成功");
        }
        return Response.ERROR("添加失败");
    }

    @RequestMapping("/queryAll")
    public Response<List<Dept>> queryAll(@RequestParam Integer pageNo, @RequestParam Integer pageNum, @RequestParam String search){
        List<Dept> depts = deptService.queryDeptPage(pageNo, pageNum,search);
        return Response.SUCCESS(depts,"查询数据成功");
    }
}
