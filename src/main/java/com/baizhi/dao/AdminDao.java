package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    void update(Admin Admin);
    Admin queryOne(@Param("glname") String glname, @Param("password")String password);
    List<Admin> queryAll();
}
