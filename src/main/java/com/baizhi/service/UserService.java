package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    User login(String password);
    void add(User user);
    void update(User user);
    User showOne(String id);
}
