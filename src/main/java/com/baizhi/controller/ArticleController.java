package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("showByPage")
    public @ResponseBody
    Map<String, Object> showByPage(Integer page, Integer rows) {
        Map<String, Object> result = new HashMap<>();
        List<Article> list = articleService.showByPage(page, rows);
        Long totals = articleService.findTotals();
        result.put("rows", list);
        result.put("total", totals);
        return result;
    }

    @ResponseBody
    @RequestMapping("removeAll")
    public Map<String, Object> delete(String[] id) {
        HashMap<String, Object> result = new HashMap<>();
        System.out.println(id);
        try {
            for (int i = 0; i < id.length; i++) {

                articleService.remove(id[i]);
            }
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("add")
    public Map<String, Object> add(MultipartFile file, Article article, HttpSession session) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            String realPath = session.getServletContext().getRealPath("/ArticleImg/");
            file.transferTo(new File(realPath, file.getOriginalFilename()));
            //存图片路径
            article.setInsertImgPath("/ArticleImg/" + file.getOriginalFilename());

            articleService.add(article);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("showOne")
    public Article showOne(String id){

        System.out.println(id);
        Article article = articleService.showOne(id);

        return article;
    }

    @ResponseBody
    @RequestMapping("update")
    public Map<String, Object> update(Article article) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            articleService.update(article);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
}
