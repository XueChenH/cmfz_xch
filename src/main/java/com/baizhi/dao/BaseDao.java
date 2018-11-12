package com.baizhi.dao;



import java.util.List;

public interface BaseDao<T> {
    void insert(T t);
    void delete(String id);
    void update(T t);
    T queryOne(String id);
    List<T> queryAll();
}
