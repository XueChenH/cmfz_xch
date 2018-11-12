package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private String id;
    private String title;
    private String content;
    private String insertImgPath;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date publishDate;
    private Guru guru;
    private String guru_id;
    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", insertImgPath='" + insertImgPath + '\'' +
                ", publishDate=" + publishDate +
                ", guru=" + guru +
                ", guru_id='" + guru_id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInsertImgPath() {
        return insertImgPath;
    }

    public void setInsertImgPath(String insertImgPath) {
        this.insertImgPath = insertImgPath;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    public Article(String id, String title, String content, String insertImgPath, Date publishDate, Guru guru, String guru_id) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.insertImgPath = insertImgPath;
        this.publishDate = publishDate;
        this.guru = guru;
        this.guru_id = guru_id;
    }
}
