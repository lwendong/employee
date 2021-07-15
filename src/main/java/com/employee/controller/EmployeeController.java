package com.employee.controller;

import com.employee.pojo.Employee;
import com.employee.pojo.User;
import com.employee.pub.Response;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getEmployeeByCode")
    public Response<Employee> getEmployeeByCode(@RequestBody String Code, HttpSession session){
        Employee employeeByCode = employeeService.getEmployeeByCode(Code);
        if(!ObjectUtils.isEmpty(employeeByCode)){
            User user = (User) session.getAttribute("user");
            user.setEmployee(employeeByCode);
            session.setAttribute("user",user);
            return Response.SUCCESS(employeeByCode,"根据id查询员工成功");
        }else{
            return  Response.ERROR("根据id查询员工失败");
        }
    }

    @RequestMapping("/queryAll")
    public Response<List<Employee>> queryAllEmployee(@RequestParam Integer pageNo, @RequestParam Integer pageNum, @RequestParam String search){
        return Response.SUCCESS(employeeService.queryEmployeePage(pageNo, pageNum, search),"查询成功");
    }

    @PostMapping("/update")
    public Response<Boolean> update(@RequestBody Employee employee){
        return Response.SUCCESS(employeeService.updateEmployee(employee),"查询成功");
    }
}
