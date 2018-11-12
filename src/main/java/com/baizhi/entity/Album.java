package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Album {
    private String id;
    private String albumpath;
    private String title;
    private int  set_count;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date create_date;
    private Double score;
    private String author;
    private String broadcast;
    private String brief;
    List<Chapter> children;

    public Album() {
    }

    public Album(String id, String albumpath, String title, int set_count, Date create_date, Double score, String author, String broadcast, String brief, List<Chapter> children) {

        this.id = id;
        this.albumpath = albumpath;
        this.title = title;
        this.set_count = set_count;
        this.create_date = create_date;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.brief = brief;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", albumpath='" + albumpath + '\'' +
                ", title='" + title + '\'' +
                ", set_count=" + set_count +
                ", create_date=" + create_date +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", brief='" + brief + '\'' +
                ", children=" + children +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumpath() {
        return albumpath;
    }

    public void setAlbumpath(String albumpath) {
        this.albumpath = albumpath;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public int getSet_count() {
        return set_count;
    }

    public void setSet_count(int set_count) {
        this.set_count = set_count;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }
}
