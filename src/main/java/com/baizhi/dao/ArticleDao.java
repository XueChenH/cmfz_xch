package com.baizhi.dao;

import com.baizhi.entity.Article;
import com.baizhi.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {
    List<Article> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    long findTotals();
    void insert(Article article);
    void delete(String id);
    void update(Article article);
    Article queryOne(String id);
}
