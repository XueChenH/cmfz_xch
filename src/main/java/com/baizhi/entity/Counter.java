package com.baizhi.entity;

import java.util.Date;

public class Counter {
    private String id;
    private String title;
    private int count;
    private String user_id;
    private String cpirse_id;
    private Date date;

    public Counter() {
    }

    public Counter(String id, String title, int count, String user_id, String cpirse_id, Date date) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.user_id = user_id;
        this.cpirse_id = cpirse_id;
        this.date = date;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCpirse_id() {
        return cpirse_id;
    }

    public void setCpirse_id(String cpirse_id) {
        this.cpirse_id = cpirse_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", user_id='" + user_id + '\'' +
                ", cpirse_id='" + cpirse_id + '\'' +
                ", date=" + date +
                '}';
    }
}
