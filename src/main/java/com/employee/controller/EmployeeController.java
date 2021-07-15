package com.employee.controller;

import com.employee.pojo.Employee;
import com.employee.pub.Response;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("getEmployeeById")
    public Response<Employee> getEmployeeById(@RequestBody String id, HttpSession session){
        Employee employeeById = employeeService.getEmployeeById(id);
        if(!ObjectUtils.isEmpty(employeeById)){
            session.setAttribute("em",employeeById);
            return Response.SUCCESS(employeeById,"根据id查询员工成功");
        }else{
            return  Response.ERROR("根据id查询员工失败");
        }
    }
}
