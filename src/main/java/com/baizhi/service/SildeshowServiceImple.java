package com.baizhi.service;

import com.baizhi.dao.SildeshowDao;
import com.baizhi.entity.Sildeshow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SildeshowServiceImple implements SildeshowService{
    @Autowired
    private SildeshowDao sildeshowDao;
    @Override
    public List<Sildeshow> showAll() {
        List<Sildeshow> list = sildeshowDao.queryAll();
        return list;
    }

    @Override
    public Sildeshow showOne(String id) {
        Sildeshow queryOne = sildeshowDao.queryOne(id);
        return queryOne;
    }

    @Override
    public void add(Sildeshow sildeshow) {
        sildeshow.setId(UUID.randomUUID().toString());
        sildeshowDao.insert(sildeshow);
    }

    @Override
    public void remove(String id) {
        sildeshowDao.delete(id);
    }

    @Override
    public void update(Sildeshow sildeshow) {
        sildeshowDao.update(sildeshow);
    }

    @Override
    public Long findTotals() {
        long totals = sildeshowDao.findTotals();
        return totals;
    }
}
