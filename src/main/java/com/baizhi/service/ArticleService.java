package com.baizhi.service;

import com.baizhi.entity.Article;


import java.util.List;

public interface ArticleService {
    List<Article> showByPage(Integer page, Integer rows);
    long findTotals();
    Article showOne(String id);
    void add(Article article);
    void remove(String id);
    void update(Article article);
}
