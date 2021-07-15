package com.employee.service;

import com.employee.pojo.User;

public interface UserService {

    public User login(User user);

    public User register(User user);

    public Boolean deleteUser(User user);
}
