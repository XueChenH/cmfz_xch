package com.baizhi.dao;

import com.baizhi.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseDao {
    List<Course> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    long findTotals();
    void insert(Course course);
    void delete(String id);
    void update(Course course);
    Course queryOne(String id);
}
