package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class ArticleServiceImple implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    public List<Article> showByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Article> articles = articleDao.queryByPage(start, rows);
        return articles;
    }

    @Override
    public long findTotals() {
        long totals = articleDao.findTotals();
        return totals;
    }

    @Override
    public Article showOne(String id) {
        Article article = articleDao.queryOne(id);
        return article;
    }

    @Override
    public void add(Article article) {
        article.setId(UUID.randomUUID().toString());
        article.setPublishDate(new Date());
        articleDao.insert(article);
    }

    @Override
    public void remove(String id) {
        articleDao.delete(id);
    }

    @Override
    public void update(Article article) {
        articleDao.update(article);
    }
}
