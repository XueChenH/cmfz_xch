package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.utils.MD5Util;
import com.baizhi.utils.RandomStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class UserServiceImple implements  UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String password) {
        User login = userDao.login(password);
        return login;
    }

    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        String salt = RandomStringUtil.getRandomString(4);
        user.setSalt(salt);
        String s = MD5Util.MD5(user.getPassword() + salt);
        user.setPassword(s);
        user.setDate(new Date());
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        String salt = RandomStringUtil.getRandomString(4);
        user.setSalt(salt);
        String s = MD5Util.MD5(user.getPassword() + salt);
        user.setPassword(s);
        userDao.update(user);
    }

    @Override
    public User showOne(String id) {

        User user = userDao.queryOne(id);
        return user;
    }
}
