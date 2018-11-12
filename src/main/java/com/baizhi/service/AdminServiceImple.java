package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AdminServiceImple implements AdminService{
    @Autowired
    private AdminDao AdminDao;
    @Override
    public void update(Admin Admin) {
        AdminDao.update(Admin);
    }

    @Override
    public Admin login(String glname,String password) {
        Admin Admin = AdminDao.queryOne(glname, password);
        return Admin;
    }

    @Override
    public List<Admin> showAll() {
        List<Admin> list = AdminDao.queryAll();
        return list;
    }
}
