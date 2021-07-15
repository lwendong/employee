package com.employee.controller;

import com.employee.pojo.User;
import com.employee.pub.Response;
import com.employee.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public Response<User> login(@RequestBody User user, HttpSession session){
        User login = userService.login(user);
        if(login != null){
            session.setAttribute("user",login);
            return Response.SUCCESS(login,"登录成功");
        }

        return Response.ERROR("登录失败");

    }

    @PostMapping(value = "/register")
    public Response<Boolean> register(@RequestBody User user, HttpSession session){
        boolean empty = ObjectUtils.isEmpty(userService.register(user));
        if(empty){
            session.setAttribute("user",user);
            return Response.SUCCESS(empty,"注册成功");
        }
        return Response.ERROR("此用户已被注册");
    }

    @PostMapping(value = "/delete")
    public Response<Boolean> delete(@RequestBody User user){
        Boolean bool = userService.deleteUser(user);
        if(bool){
            Response.SUCCESS(bool,"用户删除成功");
        }
        return Response.ERROR("用户删除失败");
    }


}
