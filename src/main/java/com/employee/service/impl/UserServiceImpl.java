package com.employee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.employee.enums.CRUDEnum;
import com.employee.mapper.EmployeeMapper;
import com.employee.mapper.UserMapper;
import com.employee.pojo.Employee;
import com.employee.pojo.User;
import com.employee.service.EmployeeService;
import com.employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
//
        User queryUser = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(queryUser)) {
            queryUser = this.register(user);
        } else {
            queryWrapper.eq("password", user.getPassword());
            queryUser = userMapper.selectOne(queryWrapper);
            if(!ObjectUtils.isEmpty(queryUser)){
                queryUser.setEmployee(employeeService.getEmployeeByCode(queryUser.getId()));
            }
        }
        return queryUser;
    }

    @Override
    public User register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        int count = userMapper.selectCount(queryWrapper);
        if (count <= CRUDEnum.NULL_COUNT.getValue()) {
            userMapper.insert(user);
            Employee build = Employee.builder().code(user.getId()).name(user.getUsername()).build();
            employeeService.addEmployee(build);
        }
        return user;
    }

    @Override
    public Boolean deleteUser(User user) {
        return userMapper.deleteById(user.getId()) > CRUDEnum.NULL_COUNT.getValue();
    }
}
