package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {
    List<Album> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    void insert(Album album);
    void update(Album album);
    void delete(String id);
    Album queryOne(String id);
    Long findTotals();
    List<Album> queryAll();
}
