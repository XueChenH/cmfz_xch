package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class AlbumServiceImple implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public List<Album> ShowByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Album> list = albumDao.queryByPage(start, rows);
        return list;
    }

    @Override
    public List<Album> ShowAll() {
        List<Album> list = albumDao.queryAll();
        return list;
    }

    @Override
    public Album showOne(String id) {
        Album album = albumDao.queryOne(id);
        return album;
    }

    @Override
    public Long findTotals() {
        Long totals = albumDao.findTotals();
        return totals;
    }

    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setCreate_date(new Date());
        albumDao.insert(album);
    }

    @Override
    public void remove(String id) {
        albumDao.delete(id);
    }

    @Override
    public void update(Album album) {
        albumDao.update(album);
    }
}
