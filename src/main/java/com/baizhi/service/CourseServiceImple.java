package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class CourseServiceImple implements CourseService{
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> showByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Course> list = courseDao.queryByPage(start, rows);
        return list;
    }

    @Override
    public long findTotals() {
        long totals = courseDao.findTotals();
        return totals;
    }

    @Override
    public Course showOne(String id) {
        Course course = courseDao.queryOne(id);
        return course;
    }

    @Override
    public void add(Course course) {
        course.setId(UUID.randomUUID().toString());
        course.setDate(new Date());
        courseDao.insert(course);
    }

    @Override
    public void remove(String id) {
        courseDao.delete(id);
    }

    @Override
    public void update(Course course) {
        courseDao.update(course);
    }
}
