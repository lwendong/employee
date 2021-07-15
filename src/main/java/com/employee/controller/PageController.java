package com.employee.controller;

import com.employee.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/index")
    public String toIndex(HttpSession session){
        User user = (User)session.getAttribute("user");
        if(ObjectUtils.isEmpty(user)){
            return "redirect:login";
        }
        return "index";
    }

    @RequestMapping("/addDept")
    public String addDept(){
        return "addDept";
    }

    @RequestMapping("/employeeList")
    public String employeeList(){
        return "employeeList";
    }

    @RequestMapping("/dept")
    public String dept(){
        return "dept";
    }
}
