package com.baizhi.entity;

public class Admin {
    private String id;
    private String name;
    private String glname;
    private String password;
    private String sex;

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", glname='" + glname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getglname() {
        return glname;
    }

    public void setglname(String glname) {
        this.glname = glname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Admin(String id, String name, String glname, String password, String sex) {
        this.id = id;
        this.name = name;
        this.glname = glname;
        this.password = password;
        this.sex = sex;
    }
}
