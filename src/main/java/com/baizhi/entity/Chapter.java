package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private String id;
    private String title;       //章节名称
    private String size;        //章节大小
    private String duration;    //章节时长
    private String downLoadPath;//章节下载路径
    private String upLoadPath;  //上传或修改时间
    private String album_id;    //所属专辑id

    public Chapter() {
    }

    public Chapter(String id, String title, String size, String duration, String downLoadPath, String upLoadPath, String album_id) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.downLoadPath = downLoadPath;
        this.upLoadPath = upLoadPath;
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", downLoadPath='" + downLoadPath + '\'' +
                ", upLoadPath='" + upLoadPath + '\'' +
                ", album_id='" + album_id + '\'' +
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownLoadPath() {
        return downLoadPath;
    }

    public void setDownLoadPath(String downLoadPath) {
        this.downLoadPath = downLoadPath;
    }

    public String getUpLoadPath() {
        return upLoadPath;
    }

    public void setUpLoadPath(String upLoadPath) {
        this.upLoadPath = upLoadPath;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }
}
