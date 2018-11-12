package com.baizhi.dao;

import com.baizhi.entity.Sildeshow;

import java.util.List;

public interface SildeshowDao {
    List<Sildeshow> queryAll();
    Sildeshow queryOne(String id);
    void insert(Sildeshow sildeshow);
    void delete(String id);
    void update(Sildeshow sildeshow);
    Long findTotals();
}
