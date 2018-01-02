package com.zm.admin.dao;

public class Teacher {
    private Integer id;

    private String name;

    private String info;

    private Integer mechanismId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getMechanismId() {
        return mechanismId;
    }

    public void setMechanismId(Integer mechanismId) {
        this.mechanismId = mechanismId;
    }
}