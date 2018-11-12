package com.baizhi.dao;

import com.baizhi.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuruDao {
    List<Guru> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    void insert(Guru guru);
    void delete(String id);
    long findTotals();
    void update(Guru guru);
    Guru queryOne(String id);
    List<Guru> queryAll();
}
