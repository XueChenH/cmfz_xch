package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Sildeshow {
    private String id;
    private String path;
    private String s_desc;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;

    public Sildeshow() {
    }

    public Sildeshow(String id, String path, String s_desc, String status, Date updatetime) {
        this.id = id;
        this.path = path;
        this.s_desc = s_desc;
        this.status = status;
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Sildeshow{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", s_desc='" + s_desc + '\'' +
                ", status='" + status + '\'' +
                ", updatetime=" + updatetime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
