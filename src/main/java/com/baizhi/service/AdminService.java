package com.baizhi.service;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminService {
    void update(Admin admin);
    Admin login(String name,String password);
    List<Admin> showAll();
}
