package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> showByPage(Integer page, Integer rows);
    long findTotals();
    Course showOne(String id);
    void add(Course course);
    void remove(String id);
    void update(Course course);
}
