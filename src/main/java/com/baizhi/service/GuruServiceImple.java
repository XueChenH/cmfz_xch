package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImple implements  GuruService{
    @Autowired
    private GuruDao guruDao;

    @Override
    public List<Guru> ShowByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Guru> list = guruDao.queryByPage(start,rows);
        return list;
    }

    @Override
    public void add(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }

    @Override
    public void remove(String id) {
        guruDao.delete(id);
    }
    @Override
    public Long findTotals(){
        long totals = guruDao.findTotals();
        return totals;
    }

    @Override
    public List<Guru> showAll() {
        List<Guru> gurus = guruDao.queryAll();
        return gurus;
    }

    @Override
    public void update(Guru guru) {
        guruDao.update(guru);
    }

    @Override
    public Guru showOne(String id) {
        Guru guru = guruDao.queryOne(id);
        return guru;
    }
}
