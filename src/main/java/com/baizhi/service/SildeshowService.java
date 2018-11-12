package com.baizhi.service;

import com.baizhi.entity.Sildeshow;

import java.util.List;

public interface SildeshowService {
    List<Sildeshow> showAll();
    Sildeshow showOne(String id);
    void add(Sildeshow sildeshow);
    void remove(String id);
    void update(Sildeshow sildeshow);
    Long findTotals();

}
