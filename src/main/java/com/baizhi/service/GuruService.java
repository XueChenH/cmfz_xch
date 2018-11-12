package com.baizhi.service;

import com.baizhi.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuruService {
    List<Guru> ShowByPage(@Param("page") Integer page, @Param("rows") Integer rows);
    void add(Guru guru);
    void remove(String id);
    Long findTotals();
    void update(Guru guru);
    Guru showOne(String id);
    List<Guru> showAll();
}
