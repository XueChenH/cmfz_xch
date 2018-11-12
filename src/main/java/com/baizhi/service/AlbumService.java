package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumService {
    List<Album> ShowByPage(@Param("page") Integer page, @Param("rows") Integer rows);
    List<Album> ShowAll();
    Album showOne(String id);
    Long findTotals();
    void add(Album album);
    void remove(String id);
    void update(Album album);
}
