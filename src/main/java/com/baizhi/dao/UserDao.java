package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.UUID;

public interface UserDao {
    void insert(User user);
    User login(String password);
    User queryOne(String id);
    void update(User user);
}
